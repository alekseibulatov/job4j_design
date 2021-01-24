package ru.job4j.generics;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] a;
    private int i = 0;

    public SimpleArray(int size) {
        this.a = (T[]) new Object[size];
    }

    /**
     * добавляет указанный элемент (model) в первую свободную ячейку
     *
     * @param model
     */
    public void add(T model) {
        a[i] = model;
        i++;
    }

    /**
     * заменяет указанным элементом (model) элемент, находящийся по индексу index
     *
     * @param index
     * @param model
     */
    public void set(int index, T model) {
        validate(index);
        a[index] = model;
    }

    /**
     * удаляет элемент по указанному индексу, все находящиеся справа элементы
     * при этом необходимо сдвинуть на единицу влево (в середине массива не должно быть пустых ячеек)
     *
     * @param index
     */
    public void remove(int index) {
        validate(index);
        System.arraycopy(a, (index + 1), a, index, (a.length - 1 - index));
        a[a.length - 1] = null;
        i--;
    }

    /**
     * возвращает элемент, расположенный по указанному индексу;
     *
     * @param index
     */
    public T get(int index) {
        validate(index);
        return a[index];
    }

    @Override
    public Iterator iterator() {
        Iterator<T> it = new Iterator<>() {
            private int indexIt = 0;

            @Override
            public boolean hasNext() {
                return indexIt < i;
            }

            @Override
            public T next() {
                return a[indexIt++];
            }
        };
        return it;
    }

    private int validate(int index) {
        return Objects.checkIndex(index, i);
    }
}



