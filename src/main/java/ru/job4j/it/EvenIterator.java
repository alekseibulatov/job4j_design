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
        boolean rsl = true;
        if (point >= numbers.length) {
            rsl = false;

        } else
            while (numbers[point] % 2 != 0) {
                point++;
                if (point >= numbers.length) {
                    rsl = false;
                    break;
                }
            }
        return rsl;
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer rsl = null;
        if (numbers[point] % 2 == 0) {
            rsl = numbers[point];
            point++;
            return rsl;
        }
        return rsl;
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
