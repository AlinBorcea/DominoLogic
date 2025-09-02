package logic.strategies;

import logic.elements.Tile;

import java.util.List;

public interface SetTileStrategy {
    void setTile(List<Tile> tableTiles, List<Tile> playerTiles) throws Exception;
}
