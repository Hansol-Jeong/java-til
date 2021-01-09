interface LinkedList<T> {
    boolean isEmpty();
    void prepend(T value);
    void append(T value);
    void settingHead(int index);
    T access(int index);
    boolean insert(int index, T value);
    void print();
    int size();
}
