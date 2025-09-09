package logic.elements;

/// The tile record contains two values representing the two faces of a tile.
/// Each Tile object is unique and owned by a single element at a time (Boneyard, Player or Table).
public record Tile(int valueA, int valueB) {

    public Tile reversed() {
        return new Tile(valueB, valueA);
    }

    public boolean matchesToLeftOfOther(Tile other) {
        return valueB == other.valueA;
    }

    public boolean matchesToRightOfOther(Tile other) {
        return valueA == other.valueB;
    }

    public int sum() {
        return valueA + valueB;
    }
}