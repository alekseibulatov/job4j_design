package ru.job4j.it;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return row < data.length;
    }


    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer rsl = null;
        for (; row < data.length; row++) {
            for (; column < data[0].length; column++) {
              rsl = data[row][column];
               if (column < data[0].length) {
                    column++;
                } else {
                    row++;
                }

                return rsl;
            }
        }
        Integer rs = null;
        for (int[] a : data) {
            for (int z : a) {
                rs = z;
                return rs;
            }
        }
        return rs;
    }
}
