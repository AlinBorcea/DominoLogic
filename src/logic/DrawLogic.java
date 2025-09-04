package logic;

import logic.elements.Table;
import logic.strategies.SetTileStrategy;

import java.util.List;

public class DrawLogic implements DominoLogic {
    private final GameData gameData;

    public DrawLogic(List<String> playerNames, SetTileStrategy setTileStrategy, Table table) throws Exception {
        this.gameData = new GameData(playerNames, setTileStrategy, table);
    }

    @Override
    public void runOneTurn() throws Exception {

    }

    @Override
    public void runMultipleTurns(int numberOfTurns) throws Exception {

    }
}
