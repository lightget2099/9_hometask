package org.example;

public class MyLinkedList {
    private class Node {
        Object value;
        Node next;
        Node prev;

        Node(Object value){
            this.value = value;
        }

    }

    private Node head;
    private Node tail;
    private int size;

    public void add(Object value){
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
        Node current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }

        if(current.prev != null){
            current.prev.next = current.next;
        } else {
            head = current.next;
        }


        if(current.next != null){
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

    public Object get(int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.value;
    }
}

