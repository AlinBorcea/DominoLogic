package logic.strategies;

import logic.elements.Tile;

import java.util.List;

public class SetFirstTileStrategy implements SetTileStrategy {
    @Override
    public void setTile(List<Tile> tableTiles, List<Tile> playerTiles) throws Exception {
        if (tableTiles.isEmpty() || playerTiles.isEmpty())
            throw new Exception("SetFirstTileStrategy: there are no tiles to match");

        var firstOnTable = tableTiles.getFirst();
        var lastOnTable = tableTiles.getLast();

        for (var tile : playerTiles) {
            var reversed = tile.reversed();
            if (tile.matchesToLeftOfOther(firstOnTable)) {
                tableTiles.addFirst(tile);
                playerTiles.remove(tile);
                break;
            } else if (tile.matchesToRightOfOther(lastOnTable)) {
                tableTiles.addLast(tile);
                playerTiles.remove(tile);
                break;
            } else if (reversed.matchesToLeftOfOther(firstOnTable)) {
                tableTiles.addFirst(reversed);
                playerTiles.remove(reversed);
                break;
            } else if (reversed.matchesToRightOfOther(lastOnTable)) {
                tableTiles.addLast(reversed);
                playerTiles.remove(reversed);
                break;
            }
        }
    }
}
