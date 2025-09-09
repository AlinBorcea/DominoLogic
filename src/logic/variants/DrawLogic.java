package logic.variants;

import logic.GameData;
import logic.elements.Table;
import logic.exceptions.BoneyardIsEmptyException;
import logic.exceptions.GameOverException;
import logic.exceptions.PlayerCannotMakeAMoveException;
import logic.exceptions.PlayerHasNoTilesException;
import logic.strategies.SetTileStrategy;

import java.util.List;

/// DrawLogic adds the ability to draw tiles from the boneyard when the current player cannot make a move.
/// The game ends when one player has set all their tiles or when no player can make a move despite drawing tiles.
public class DrawLogic implements DominoLogic {
    private final GameData gameData;
    private int failedTurns = 0;

    public DrawLogic(List<String> playerNames, SetTileStrategy setTileStrategy) throws Exception {
        this.gameData = new GameData(playerNames, setTileStrategy, new Table());
    }

    @Override
    public void runOneTurn() throws Exception {
        try {
            gameData.runTurn();
            failedTurns = 0;
            gameData.goToNextPlayer();

        }  catch (PlayerCannotMakeAMoveException e) {
            try {
                giveTilesToCurrentPlayerAndRerunTurn();
            } catch (BoneyardIsEmptyException be) {
                failedTurns++;
                if (failedTurns == gameData.playerCount()) throw new GameOverException("Neither player could make finish a turn");
                gameData.goToNextPlayer();
            }

        } catch (PlayerHasNoTilesException e) {
            throw new GameOverException("Game Over! player is out of tiles");
        }
    }

    @Override
    public void resetTurn() {
        gameData.resetTurn();
    }

    @Override
    public void calculateEndGameScore() {
        gameData.calculateEndGameScore();
    }

    private void giveTilesToCurrentPlayerAndRerunTurn() throws Exception {
        gameData.giveCurrentPlayerTilesUntilValidOrEmpty();
        this.runOneTurn();
    }
}
