package logic;

import logic.elements.Table;
import logic.strategies.SetTileStrategy;

import java.util.List;

public class BlockLogic implements DominoLogic {
    private final GameData gameData;
    private int failedTurns = 0;

    public BlockLogic(List<String> playerNames, SetTileStrategy setTileStrategy, Table table) throws Exception {
        this.gameData = new GameData(playerNames, setTileStrategy, table);
    }


    @Override
    public void runOneTurn() throws Exception {
        try {
            gameData.runTurn();
            failedTurns = 0;
        } catch (Exception e) {
            gameData.goToNextPlayer();
            failedTurns++;
            if (failedTurns == gameData.playerCount()) {
                throw new Exception("All player have failed to place pips");
            }
        }
    }

    @Override
    public void runMultipleTurns(int numberOfTurns) throws Exception {
        while (numberOfTurns > 0) {
            runOneTurn();
            numberOfTurns--;
        }
    }
}
