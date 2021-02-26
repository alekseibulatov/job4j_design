package ru.job4j.collection;

import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {
    private  final T[] array;

    public SimpleArray(int size) {
        this.array = (T[]) new Object[size];
    }


    public T get(int index) {
        return null;
    }
    public void add(T model) {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
