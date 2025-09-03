package logic;

import logic.elements.*;

import java.util.ArrayList;
import java.util.List;

public class GameData {
    private Boneyard boneyard;
    private final CircularList<Player> players;
    private final Table table;

    public GameData(List<String> playerNames, Table table) throws Exception {
        this.table = table;
        boneyard = new Boneyard();

        var playerList = new ArrayList<Player>();
        for (String name : playerNames) {
            var player = new Player(boneyard.takeTiles(7), name);
            playerList.add(player);
        }

        players = new CircularList<>(playerList, 0);
    }
}
