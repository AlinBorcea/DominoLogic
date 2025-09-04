package logic;

import logic.elements.Table;
import logic.strategies.SetTileStrategy;

import java.util.List;

public class MultiplesLogic implements DominoLogic {
    private final GameData gameData;
    private final int multiple;
    private int failedTurns = 0;

    public MultiplesLogic(List<String> playerNames, SetTileStrategy setTileStrategy, Table table, int multiple) throws Exception {
        this.gameData = new GameData(playerNames, setTileStrategy, table);
        this.multiple = multiple;
    }

    @Override
    public void runOneTurn() throws Exception {
        try {
            gameData.runTurn();
            failedTurns = 0;
            gameData.goToNextPlayer();
        } catch (Exception e) {
            gameData.goToNextPlayer();
            failedTurns++;
            if (failedTurns == gameData.playerCount()) {
                throw new Exception("All player have failed to place pips");
            }
        }
    }
}
