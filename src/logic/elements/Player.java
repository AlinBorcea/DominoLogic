package logic.elements;

import logic.strategies.SetTileStrategy;

import java.util.ArrayList;
import java.util.List;

/// Player stores the tiles, name and score of a player.
public class Player {
    private List<Tile> tiles;
    private String name;
    private int score;

    public Player(List<Tile> tiles, String name) {
        this.tiles = tiles;
        this.name = name;
        score = 0;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void addTile(Tile tile) {
        tiles.add(tile);
    }

    public boolean hasNoTiles() {
        return tiles.isEmpty();
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void emptyTiles() {
        tiles = new ArrayList<>();
    }

    public int getValueOfTiles() {
        int sum = 0;
        for (var tile : tiles) {
            sum += tile.sum();
        }

        return sum;
    }
}