package logic.elements;

import java.util.ArrayList;
import java.util.List;

public class SpinnerTable implements Table {
    private final SimpleTable simpleTable;
    private final List<Tile> spinnerTiles;
    private Tile spinnerTile;

    public SpinnerTable(SimpleTable simpleTable) {
        this.simpleTable = simpleTable;
        spinnerTiles = new ArrayList<>();
    }

    @Override
    public boolean tileCanBeSet(Tile tile) {
        if (simpleTable.tileCanBeSet(tile)) return true;

        var left = spinnerTiles.getFirst();
        var right = spinnerTiles.getLast();
        var reversed = tile.reversed();

        return tile.matchesToLeftOfOther(left) || tile.matchesToRightOfOther(right) ||
                reversed.matchesToLeftOfOther(left) || reversed.matchesToRightOfOther(right);
    }

    @Override
    public int getTableScore() {
        int score = simpleTable.getTableScore();

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
