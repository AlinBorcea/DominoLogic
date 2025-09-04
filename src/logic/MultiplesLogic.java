package logic;

import logic.elements.Table;
import logic.strategies.SetTileStrategy;

import java.util.List;

public class MultiplesLogic implements DominoLogic {
    private final GameData gameData;
    private final int multiple;

    public MultiplesLogic(List<String> playerNames, SetTileStrategy setTileStrategy, Table table, int multiple) throws Exception {
        this.gameData = new GameData(playerNames, setTileStrategy, table);
        this.multiple = multiple;
    }

    @Override
    public void runOneTurn() throws Exception {

    }

    @Override
    public void runMultipleTurns(int numberOfTurns) throws Exception {

    }
}
