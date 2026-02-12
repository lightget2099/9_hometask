package org.example;
import java.util.*;

public class MyQueue<T> {
    private T[] data;
    private int size;

@SuppressWarnings("unchecked")
    public MyQueue(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void add(T value) {
        if (size == data.length) {
            T[] temp = (T[]) new Object[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }


        data[size++] = value;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (size == 0) {
            return null;
        } else {
            return data[0];
        }
    }

    public T poll() {
        if (size == 0) {
            return null;
        }
        T first = data[0];
        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return first;
    }
}



