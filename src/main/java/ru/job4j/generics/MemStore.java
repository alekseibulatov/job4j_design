package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();


    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        if (findById(id) == null) {
            result = false;
        } else {
            mem.set(mem.indexOf(id), model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        mem.remove(mem.indexOf(id));
        return false;
    }

    @Override
    public T findById(String id) {
        return null;
    }
}
