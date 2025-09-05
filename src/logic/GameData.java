package logic;

import logic.elements.*;
import logic.exceptions.PlayerCannotMakeAMoveException;
import logic.strategies.SetTileStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameData {
    private final SetTileStrategy setTileStrategy;
    private Boneyard boneyard;
    private final CircularList<Player> players;
    private final Table table;

    public GameData(List<String> playerNames, SetTileStrategy setTileStrategy, Table table) throws Exception {
        this.setTileStrategy = setTileStrategy;
        this.table = table;
        boneyard = new Boneyard();

        var playerList = new ArrayList<Player>();
        for (String name : playerNames) {
            var player = new Player(boneyard.takeTiles(7), name);
            playerList.add(player);
        }

        players = new CircularList<>(playerList, 0);
    }

    public void runTurn() throws Exception {
        players.getCurrent().setOneTileOnTableUsingStrategy(table, setTileStrategy);
    }

    public void supplyCurrentPlayerWithTilesUntilValidOrEmpty() throws Exception {
        var player = players.getCurrent();
        Tile tile;

        do {
            tile = boneyard.takeOneTile();
            player.addTile(tile);

        } while (!table.tileCanBeSet(tile));

        if (boneyard.isEmpty() && !table.tileCanBeSet(tile)) throw new PlayerCannotMakeAMoveException("No tile could be supplied");
    }

    public void goToNextPlayer() {
        players.next();
    }

    public int playerCount() {
        return players.count();
    }

}
