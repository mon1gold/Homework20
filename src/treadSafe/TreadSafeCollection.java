package treadSafe;

public interface TreadSafeCollection<T> {
    void add(T element);

    void remove(T element);

    T get(int index);

}
