package logic;

import java.util.List;

public class Table {
    private final List<Tile> tiles;

    public Table(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public List<Tile> getTiles() {
        return tiles;
    }
}
