package logic.elements;

import logic.strategies.SetTileStrategy;

import java.util.List;

public class Player {
    private final List<Tile> tiles;
    private String name;
    private int score;

    public Player(List<Tile> tiles) {
        this.tiles = tiles;
        name = "Nameless";
        score = 0;
    }

    public Player(List<Tile> tiles, String name) {
        this.tiles = tiles;
        this.name = name;
        score = 0;
    }

    public void setOneTileOnTableUsingStrategy(Table table, SetTileStrategy strategy) throws Exception {
        strategy.setTile(table.getTiles(), tiles);
    }

}