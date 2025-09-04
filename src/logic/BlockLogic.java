package logic;

import logic.elements.Table;
import logic.strategies.SetTileStrategy;

import java.util.List;

public class BlockLogic implements DominoLogic {
    private final GameData gameData;

    public BlockLogic(List<String> playerNames, SetTileStrategy setTileStrategy, Table table) throws Exception {
        this.gameData = new GameData(playerNames, setTileStrategy, table);
    }
}
