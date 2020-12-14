package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class EvenIterator implements Iterator<Integer> {
    private final int[] numbers;
    private int point = 0;


    public EvenIterator(int[] numbers) {
        this.numbers = numbers;
    }


    @Override
    public boolean hasNext() {
        while (point < numbers.length && numbers[point] % 2 != 0) {
            point++;
        }
        return point < numbers.length;
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[point++];
    }


    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEachRemaining(Consumer<? super Integer> action) {
        throw new UnsupportedOperationException();
    }
}
