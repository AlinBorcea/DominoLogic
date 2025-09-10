package logic.elements;

import java.util.ArrayList;
import java.util.List;

/// Table stores the tiles set be every player and calculates the table score.
public class Table {
    private final List<Tile> tiles;
    private final List<Tile> spinnerTiles;
    private Tile spinnerTile;

    public Table() {
        this.tiles = new ArrayList<>();
        spinnerTiles = new ArrayList<>();
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public List<Tile> getSpinnerTiles() {
        return spinnerTiles;
    }

    public void setSpinnerTile(Tile spinnerTile) {
        this.spinnerTile = spinnerTile;
        spinnerTiles.add(spinnerTile);
    }

    public boolean tileCanBeSet(Tile tile) {
        if (tiles.isEmpty()) return true;

        var left = tiles.getFirst();
        var right = tiles.getLast();
        var reversed = tile.reversed();

        return tile.matchesToLeftOfOther(left) || tile.matchesToRightOfOther(right) ||
                reversed.matchesToLeftOfOther(left) || reversed.matchesToRightOfOther(right);
    }

    public boolean tileCanBeSetWithSpinner(Tile tile) {
        if (tileCanBeSet(tile)) return true;

        var left = spinnerTiles.getFirst();
        var right = spinnerTiles.getLast();
        var reversed = tile.reversed();

        return tile.matchesToLeftOfOther(left) || tile.matchesToRightOfOther(right) ||
                reversed.matchesToLeftOfOther(left) || reversed.matchesToRightOfOther(right);
    }

    public int getTableScore() {
        return tiles.isEmpty() ? -1 : tiles.getFirst().valueA() + tiles.getLast().valueB();
    }

    public int getTableScoreWithSpinner() {
        int score = getTableScore();

        if (spinnerTiles.isEmpty() || spinnerTiles.size() == 1) return score;

        var left = spinnerTiles.getFirst();
        var right = spinnerTiles.getLast();

        if (left != spinnerTile) {
            score += left.valueA();
            if (left.isDouble()) {
                score += left.valueA();
            }
        }
        if (right != spinnerTile) {
            score += right.valueB();
            if (right.isDouble()) {
                score += right.valueB();
            }
        }

        return score;
    }
}
