package org.example;
import java.util.*;

public class MyArrayList<T> {
    private T[] data;
    private int size;

    //були проблеми з компілятором, то гуглив, щоб вирішити проблему, і використав цю анотацію
    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void add(T value){
        if(size == data.length){
            @SuppressWarnings("unchekkced")
                    T[] newData = (T[]) new Object[data.length*2];
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
