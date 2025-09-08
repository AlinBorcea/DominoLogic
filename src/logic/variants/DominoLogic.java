package logic.variants;

public interface DominoLogic {
    void runOneTurn() throws Exception;
    void calculateEndGameScore();

    default void runMultipleTurns(int numberOfTurns) throws Exception {
        while (numberOfTurns > 0) {
            runOneTurn();
            numberOfTurns--;
        }
    }
}
