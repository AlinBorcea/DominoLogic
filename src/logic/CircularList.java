package logic;

import java.util.List;

public class CircularList<T> {
    private final List<T> elements;
    private int index;

    public CircularList(List<T> elements, int index) {
        this.elements = elements;
        this.index = index;
    }

    public T next() {
        index = index + 1 >= elements.size() ? 0 : index + 1;
        return elements.get(index);
    }

    public T getCurrent() {
        return elements.get(index);
    }

    public List<T> getList() {
        return elements;
    }

    public int count() {
        return elements.size();
    }
}
