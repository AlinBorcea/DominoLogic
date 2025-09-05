package logic;

import logic.elements.Table;
import logic.exceptions.GameOverException;
import logic.exceptions.PlayerCannotMakeAMoveException;
import logic.exceptions.PlayerHasNoTilesException;
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
            gameData.goToNextPlayer();

        } catch (PlayerCannotMakeAMoveException e) {
            gameData.goToNextPlayer();
            failedTurns++;
            if (failedTurns == gameData.playerCount()) {
                throw new GameOverException("All player have failed to place pips");
            }

        } catch (PlayerHasNoTilesException e) {
            throw new GameOverException("Game Over! player is out of tiles");
        }
    }
}
