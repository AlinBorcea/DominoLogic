package logic.strategies;

import logic.elements.Tile;

import java.util.List;

public class SetFirstTileStrategy implements SetTileStrategy {
    @Override
    public void setTile(List<Tile> tableTiles, List<Tile> playerTiles) throws Exception {
        if (playerTiles.isEmpty())
            throw new Exception("SetFirstTileStrategy: player has no tiles");

        if (tableTiles.isEmpty()) {
            tableTiles.add(playerTiles.getFirst());
            playerTiles.removeFirst();
            return;
        }

        var firstOnTable = tableTiles.getFirst();
        var lastOnTable = tableTiles.getLast();

        for (var tile : playerTiles) {
            var reversed = tile.reversed();
            if (tile.matchesToLeftOfOther(firstOnTable)) {
                tableTiles.addFirst(tile);
                playerTiles.remove(tile);
                return;
            } else if (tile.matchesToRightOfOther(lastOnTable)) {
                tableTiles.addLast(tile);
                playerTiles.remove(tile);
                return;
            } else if (reversed.matchesToLeftOfOther(firstOnTable)) {
                tableTiles.addFirst(reversed);
                playerTiles.remove(tile);
                return;
            } else if (reversed.matchesToRightOfOther(lastOnTable)) {
                tableTiles.addLast(reversed);
                playerTiles.remove(tile);
                return;
            }
        }

        throw new Exception("Player cannot make a move");
    }
}
