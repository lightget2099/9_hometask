package org.example;

public class MyQueue {
    private Object[] data;
    private int size;

    public MyQueue(int capacity) {
        data = new Object[capacity];
        size = 0;
    }

    public void add(Object value) {
        if (size == data.length) {
            Object[] temp = new Object[data.length * 2];
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

    public Object peek() {
        if (size == 0) {
            return null;
        } else {
            return data[0];
        }
    }

    public Object poll() {
        if (size == 0) {
            return null;
        }
        Object first = data[0];
        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return first;
    }
}



