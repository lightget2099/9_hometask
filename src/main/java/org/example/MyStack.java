package org.example;

public class MyStack {
    private Object[] data;
    private int size;

    public MyStack(int capacity){
        data = new Object[capacity];
    }

    public void push(Object value){
        if(size == data.length){
            Object[] newData = new Object[data.length*2];
            for(int i=0; i<data.length; i++){
                newData[i] = data[i];
            }
            data = newData;
        }
        data[size] = value;
        size++;
    }

    public Object remove(int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Object removed = data[index];
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

    public Object peek(){
        if(size == 0){
            return null;
        }else {
            return data[size-1];
        }
    }

    public Object pop(){
        if(size == 0){
            return null;
        }
        Object removed = data[size-1];
        data[size-1] = null;
        size--;
        return removed;
    }


}
