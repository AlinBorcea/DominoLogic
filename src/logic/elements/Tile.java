package logic.elements;

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