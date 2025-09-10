package logic.elements;

import java.util.ArrayList;
import java.util.List;

/// Table stores the tiles set be every player and calculates the table score.
public class SimpleTable implements Table {
    private final List<Tile> tiles;


    public SimpleTable() {
        this.tiles = new ArrayList<>();
    }

    public List<Tile> getTiles() {
        return tiles;
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
        return tiles.isEmpty() ? -1 : tiles.getFirst().valueA() + tiles.getLast().valueB();
    }
}
