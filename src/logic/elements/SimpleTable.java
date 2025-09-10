package logic.elements;

import logic.strategies.SetTileStrategy;

import java.util.ArrayList;
import java.util.List;

/// Table stores the tiles set be every player and calculates the table score.
public class SimpleTable implements Table {
    private final List<Tile> tiles = new ArrayList<>();

    @Override
    public Tile setTileUsingStrategy(List<Tile> playerTiles, SetTileStrategy strategy) throws Exception {
        return strategy.setTile(tiles, playerTiles);
    }

    public boolean tileCanBeSet(Tile tile) {
        if (tiles.isEmpty()) return true;

        var left = tiles.getFirst();
        var right = tiles.getLast();
        var reversed = tile.reversed();

        return tile.matchesToLeftOfOther(left) || tile.matchesToRightOfOther(right) ||
                reversed.matchesToLeftOfOther(left) || reversed.matchesToRightOfOther(right);
    }

    public int getTableScore() {
        if (tiles.isEmpty()) return 0;

        var first = tiles.getFirst();
        var last = tiles.getLast();
        int score = first.valueA() + last.valueB();

        if (tiles.size() == 1) return score;

        if (first.isDouble()) {
            score += first.valueA();
        }

        if (last.isDouble()) {
            score += last.valueB();
        }

        return score;
    }
}
