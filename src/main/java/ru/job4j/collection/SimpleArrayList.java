package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        container = (T[]) new Object[capacity];
    }


    public void increaseContainer() {
        container = Arrays.copyOf(container, (container.length + 1) * 2);
    }

    @Override
    public void add(T value) {
        if (size == container.length) {
            increaseContainer();
        }
        container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size());
        T oldValue = container[index];
        container[index] = newValue;
        return oldValue;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size());
        int newSize = size() - 1;
        T oldValue = container[index];
        if (newSize > index) {
            System.arraycopy(container, index + 1, container, index, newSize - index);
            container[newSize] = null;
            size = newSize;
            modCount++;
        }
        return oldValue;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size());
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            final int expectedModCount = modCount;
            int nextIndex = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return nextIndex < size();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[nextIndex++];
            }
        };
    }
}
