package logic.strategies;

import logic.elements.Tile;
import logic.exceptions.PlayerCannotMakeAMoveException;
import logic.exceptions.PlayerHasNoTilesException;

import java.util.List;

/// SetFirstTileStrategy implements SetTileStrategy and sets the first valid tile on the table.
public class SetFirstTileStrategy implements SetTileStrategy {
    @Override
    public Tile setTile(List<Tile> tableTiles, List<Tile> playerTiles) throws Exception {
        if (playerTiles.isEmpty())
            throw new PlayerHasNoTilesException("SetFirstTileStrategy: player has no tiles");

        if (tableTiles.isEmpty()) {
            Tile first = playerTiles.getFirst();
            tableTiles.add(first);
            playerTiles.removeFirst();
            return first;
        }

        var firstOnTable = tableTiles.getFirst();
        var lastOnTable = tableTiles.getLast();

        for (var tile : playerTiles) {
            var reversed = tile.reversed();
            if (tile.matchesToLeftOfOther(firstOnTable)) {
                tableTiles.addFirst(tile);
                playerTiles.remove(tile);
                return tile;
            } else if (tile.matchesToRightOfOther(lastOnTable)) {
                tableTiles.addLast(tile);
                playerTiles.remove(tile);
                return tile;
            } else if (reversed.matchesToLeftOfOther(firstOnTable)) {
                tableTiles.addFirst(reversed);
                playerTiles.remove(tile);
                return tile;
            } else if (reversed.matchesToRightOfOther(lastOnTable)) {
                tableTiles.addLast(reversed);
                playerTiles.remove(tile);
                return tile;
            }
        }

        throw new PlayerCannotMakeAMoveException("Player cannot make a move");
    }
}
