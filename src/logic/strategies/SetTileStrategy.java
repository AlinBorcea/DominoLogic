package logic.strategies;

import logic.elements.Tile;

import java.util.List;

/// An interface used to define the logic by which a tile should be placed on the table.
/// Examples: SetFirstTile, setLastTile, setFirstScoringTile, setTileWithMostCommonFace.
/// Can be used to extend functionality.
public interface SetTileStrategy {
    void setTile(List<Tile> tableTiles, List<Tile> playerTiles) throws Exception;
}
