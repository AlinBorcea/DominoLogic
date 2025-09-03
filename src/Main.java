import logic.BlockLogic;
import logic.DominoLogic;
import logic.strategies.SetFirstTileStrategy;

public class Main {
    private static DominoLogic dominoLogic;

    public static void main(String[] args) {
        try {
            dominoLogic = new BlockLogic(new SetFirstTileStrategy());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            System.out.println(dominoLogic);
        }
    }
}