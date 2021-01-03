package ru.job4j.generics;

import org.junit.Test;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {
    @Test
    public void whenAddThenGet() {
        SimpleArray<String> array = new SimpleArray<>(new String[10]);
        array.add("first");
        String rsl1 = array.get(0);
        assertThat(rsl1, is("first"));
        array.add("second");
        String rsl2 = array.get(1);
        assertThat(rsl2, is("second"));
    }

    @Test
    public void whenAddThenSet() {
        SimpleArray<String> array = new SimpleArray<>(new String[10]);
        array.add("first");
        array.set(0, "four");
        String rsl = array.get(0);
        assertThat(rsl, is("four"));
    }

    @Test
    public void whenRemove() {
        SimpleArray<String> array = new SimpleArray<>(new String[4]);
        array.add("first");
        array.add("second");
        array.add("third");
        array.add("four");
        array.remove(2);
        String rsl = array.get(2);
        assertThat(rsl, is("four"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleArray<String> array = new SimpleArray<>(new String[4]);
        array.add("first");
        Object rsl = array.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleArray<String> array = new SimpleArray<>(new String[0]);
        array.get(0);
    }

   @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleArray<String> array = new SimpleArray<>(new String[1]);
        array.add("first");
       array.get(1);
    }
}
