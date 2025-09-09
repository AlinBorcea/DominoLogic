package logic.variants;

/// DominoLogic defines the behavior of each game variant.
public interface DominoLogic {
    void calculateEndGameScore();
    void resetTurn();
    void runOneTurn() throws Exception;

    default void runMultipleTurns(int numberOfTurns) throws Exception {
        while (numberOfTurns > 0) {
            runOneTurn();
            numberOfTurns--;
        }
    }
}
