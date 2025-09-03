package logic;

import logic.elements.Player;
import logic.elements.Table;
import logic.strategies.SetTileStrategy;

import java.util.Arrays;

public class BlockLogic implements DominoLogic {
    private final GameData gameData;
    private final SetTileStrategy setTileStrategy;

    public BlockLogic(SetTileStrategy setTileStrategy) throws Exception {
        this.gameData = new GameData(Arrays.asList("P1", "P2"), new Table());
        this.setTileStrategy = setTileStrategy;
    }
}
