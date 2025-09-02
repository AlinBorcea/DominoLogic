package logic.elements;

public class Tile {
    private int valueA;
    private int valueB;

    public Tile(int valueA, int valueB) {
        this.valueA = valueA;
        this.valueB = valueB;
    }

    public int getValueA() {
        return valueA;
    }

    public int getValueB() {
        return valueB;
    }

    public Tile reversed() {
        return new Tile(valueB, valueA);
    }

    public boolean matchesToLeftOfOther(Tile other) {
        return valueB == other.valueA;
    }

    public boolean matchesToRightOfOther(Tile other) {
        return valueA == other.valueB;
    }

}