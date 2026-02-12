package org.example;
import java.util.*;

public class MyLinkedList<T> {
    private class Node {
        T value;
        Node next;
        Node prev;

        Node(T value){
            this.value = value;
        }

    }

    private Node head;
    private Node tail;
    private int size;

    public void add(T value){
        Node node = new Node(value);
        if(head == null){
            head = node;
            tail = node;
        }else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void remove(int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }

        size--;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public T get(int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current;

        //Я зрозумів, що так буде швидше, якщо будемо працювати з великим списком

        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current.value;
    }
}

