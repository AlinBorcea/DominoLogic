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

    public BlockLogic(List<String> playerNames, SetTileStrategy setTileStrategy) throws Exception {
        this.gameData = new GameData(playerNames, setTileStrategy, new Table());
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

    @Override
    public void calculateEndGameScore() {
        gameData.calculateEndGameScore();
    }
}
