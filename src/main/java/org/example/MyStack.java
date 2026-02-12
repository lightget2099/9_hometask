package org.example;
import java.util.*;

public class MyStack<T> {
    private T[] data;
    private int size;
@SuppressWarnings("unchecked")
    public MyStack(int capacity){
        data = (T[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public void push(T value){
        if(size == data.length){
            T[] newData = (T[]) new Object[data.length*2];
            for(int i=0; i<data.length; i++){
                newData[i] = data[i];
            }
            data = newData;
        }
        data[size] = value;
        size++;
    }

    public T remove(int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        T removed = data[index];
        for(int i = index; i< size-1; i++){
            data[i] = data[i+1];
        }
        data[size-1] = null;
        size--;
        return removed;
    }
    public void clear(){
        for(int i=0; i<size; i++){
            data[i] = null;
        }
        size = 0;
    }

    public int size(){
        return size;
    }

    public T peek(){
        if(size == 0){
            return null;
        }else {
            return data[size-1];
        }
    }

    public T pop(){
        if(size == 0){
            return null;
        }
        T removed = data[size-1];
        data[size-1] = null;
        size--;
        return removed;
    }


}
