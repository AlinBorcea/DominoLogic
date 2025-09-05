import logic.BlockLogic;
import logic.DominoLogic;
import logic.DrawLogic;
import logic.elements.Table;
import logic.exceptions.GameOverException;
import logic.strategies.SetFirstTileStrategy;

import java.util.Arrays;

public class Main {
    private static DominoLogic dominoLogic;

    public static void main(String[] args) {
        try {
            dominoLogic = new DrawLogic(Arrays.asList("P1", "P2"), new SetFirstTileStrategy());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            System.out.println(dominoLogic);
        }

        try {
            dominoLogic.runMultipleTurns(40);
        } catch (GameOverException e) {
            System.out.println("Game over!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(dominoLogic);
        }
    }
}