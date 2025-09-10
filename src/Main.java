import logic.variants.BlockLogic;
import logic.variants.DominoLogic;
import logic.exceptions.GameOverException;
import logic.strategies.SetFirstTileStrategy;
import logic.variants.MultiplesLogic;

import java.util.Arrays;

public class Main {
    private static DominoLogic dominoLogic;

    public static void main(String[] args) {
        try {
            dominoLogic = new MultiplesLogic(Arrays.asList("P1", "P2"), new SetFirstTileStrategy(), 5);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            System.out.println(dominoLogic);
        }

        try {
            dominoLogic.runMultipleTurns(10);
        } catch (GameOverException e) {
            System.out.println("Game over!");
            dominoLogic.calculateEndGameScore();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(dominoLogic);
        }
    }
}