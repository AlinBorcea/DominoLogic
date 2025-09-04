package logic;

public interface DominoLogic {
    void runOneTurn() throws Exception;
    default void runMultipleTurns(int numberOfTurns) throws Exception {
        while (numberOfTurns > 0) {
            runOneTurn();
            numberOfTurns--;
        }
    }
}
