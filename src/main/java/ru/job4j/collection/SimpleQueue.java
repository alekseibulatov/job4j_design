package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {

    private final SimpleStack<T> input = new SimpleStack<>();
    private final SimpleStack<T> output = new SimpleStack<>();
    int count = 0;

    public T poll() {
        if (count == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        for (int i = 0; i < count; i++) {
            output.push(input.pop());
        }
        T rsl = output.pop();
        count--;
        for (int i = 0; i < count; i++) {
            input.push(output.pop());
        }
        return rsl;
    }

    public void push(T value) {
        input.push(value);
        count++;
    }
}





