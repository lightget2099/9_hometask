package org.example;

import java.util.*;

public class MyHashMap<K, V> {
    private class Node{
        K key;
        V value;
        Node next;
        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    private final int CAPACITY = 16;

    @SuppressWarnings("unchecked")
    private Node<K, V>[] bucket = (Node<K, V>[]) new Node[CAPACITY];
    int size;

    public void put(K key, V value){
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

    public V get(K key){
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

    public V remove(K key) {
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
