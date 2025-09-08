package logic.variants;

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
