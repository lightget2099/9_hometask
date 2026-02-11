package org.example;

public class MyHashMap {
    private class Node{
        Object key;
        Object value;
        Node next;
        Node(Object key, Object value){
            this.key = key;
            this.value = value;
        }
    }
    private final int CAPACITY = 16;
    Node[] bucket = new Node[CAPACITY];
    int size;

    public void put(Object key, Object value){
        int index = key.hashCode() % CAPACITY;
        Node current = bucket[index];
        while(current != null){
            if(current.key.equals(key)){
                current.value = value;
                return;
            }
            current = current.next;
        }
        Node node = new Node(key, value);
        node.next = bucket[index];
        bucket[index] = node;
        size++;
    }

    public Object get(Object key){
        int index = key.hashCode() % CAPACITY;
        Node current = bucket[index];
        while(current != null){
            if(current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public Object remove(Object key) {
        int index = key.hashCode() % CAPACITY;
        Node current = bucket[index];
        Node prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    bucket[index] = current.next;
                } else prev.next = current.next;
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }
    public int size(){
        return size;
    }

    public void clear(){
        for(int i = 0; i < CAPACITY; i++){
            bucket[i] = null;
        }
        size = 0;
    }
    }
