package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {

    private int size;
    private int modCount;
    private Node<T> head;

    public void add(T value) {
        Node<T> l = head;
        Node<T> newNode = new Node<>(value, null);
        if (l == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        modCount++;
    }

    public void addFirst(T t) {
        head = new Node<>(t, head);
    }

    public T get(int index) {
        Objects.checkIndex(index, size());
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    public int size() {
        return size;
    }

    public T deleteFirst() {
        Node<T> current = head;
        if (current == null) {
            throw new NoSuchElementException();
        }
        T deleteItem = current.item;
        Node<T> next = head.next;
        current.item = null;
        current.next = null;
        head = next;
        size--;
        modCount++;
        return deleteItem;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            final int expectedModCount = modCount;
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = current.item;
                current = current.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T item;
        Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}
