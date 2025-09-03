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
}
