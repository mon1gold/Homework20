package treadSafe;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeList<T> implements TreadSafeCollection<T> {
    List<T> elements = new ArrayList<>();

    @Override
    public synchronized void add(T element) {
        elements.add(element);
    }

    @Override
    public synchronized void remove(T element) {
        elements.remove(element);

    }

    @Override
    public synchronized T get(int index) {
        return elements.get(index);
    }

}
