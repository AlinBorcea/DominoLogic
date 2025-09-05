package logic.elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Boneyard {
    private final List<Tile> tiles;
    private final Random random;

    public Boneyard() {
        random = new Random();
        tiles = new ArrayList<>(Arrays.asList(new Tile(0, 0), new Tile(0, 1), new Tile(0, 2), new Tile(0, 3), new Tile(0, 4), new Tile(0, 5), new Tile(0, 6),
                new Tile(1, 1), new Tile(1, 2), new Tile(1, 3), new Tile(1, 4), new Tile(1, 5), new Tile(1, 6),
                new Tile(2, 2), new Tile(2, 3), new Tile(2, 4), new Tile(2, 5), new Tile(2, 6),
                new Tile(3, 3), new Tile(3, 4), new Tile(3, 5), new Tile(3, 6),
                new Tile(4, 4), new Tile(4, 5), new Tile(4, 6),
                new Tile(5, 5), new Tile(5, 6),
                new Tile(6, 6)
        ));
    }

    public boolean isEmpty() {
        return tiles.isEmpty();
    }

    public Tile takeOneTile() throws Exception {
        if (tiles.isEmpty()) throw new Exception("Boneyard: there are no more tiles to take");
        var randomIndex = random.nextInt() % tiles.size();
        randomIndex = randomIndex < 0 ? randomIndex*(-1) : randomIndex;

        return tiles.remove(randomIndex);
    }

    public List<Tile> takeTiles(int howMany) throws Exception {
        if (howMany <= 0 || howMany > tiles.size()) throw new Exception("Boneyard: value " + howMany + " is out of range");
        var takenTiles = new ArrayList<Tile>();
        while (howMany > 0) {
            howMany--;
            takenTiles.add(takeOneTile());
        }

        return takenTiles;
    }
}