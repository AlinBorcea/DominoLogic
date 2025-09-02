package logic;

import java.util.List;

public interface SetTileStrategy {
    void setTile(List<Tile> tableTiles, List<Tile> playerTiles) throws Exception;
}
