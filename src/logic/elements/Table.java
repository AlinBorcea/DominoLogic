package logic.elements;

import logic.strategies.SetTileStrategy;

import java.util.List;

public interface Table {
    Tile setTileUsingStrategy(List<Tile> playerTiles, SetTileStrategy strategy) throws Exception;
    boolean tileCanBeSet(Tile tile);
    int getTableScore();
}
