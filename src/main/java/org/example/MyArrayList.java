package org.example;

public class MyArrayList {
    private Object[] data;
    private int size;
    public MyArrayList(int capacity) {
        data = new Object[capacity];
        size = 0;
    }

    public void add(Object value){
        if(size == data.length){
            Object[] newData = new Object[data.length*2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }

            data = newData;
        }
        data[size] = value;
        size++;
    }

    public void remove(int index){
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        for(int i = index; i < size - 1; i++){
            data[i] = data[i+1];
        }
        data[size - 1] = null;
        size--;
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
}
