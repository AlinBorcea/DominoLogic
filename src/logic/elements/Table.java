package logic.elements;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final List<Tile> tiles;

    public Table() {
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
}
