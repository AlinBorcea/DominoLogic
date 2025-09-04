import logic.BlockLogic;
import logic.DominoLogic;
import logic.elements.Table;
import logic.strategies.SetFirstTileStrategy;

import java.util.Arrays;

public class Main {
    private static DominoLogic dominoLogic;

    public static void main(String[] args) {
        try {
            dominoLogic = new BlockLogic(Arrays.asList("P1", "P2"), new SetFirstTileStrategy(), new Table());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            System.out.println(dominoLogic);
        }

        try {
            dominoLogic.runMultipleTurns(10);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(dominoLogic);
        }
    }
}