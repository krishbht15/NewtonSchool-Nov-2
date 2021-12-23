package com.company.dec23rd;

public class LinkedList {
    Node head;
    Node tail;
    int size;

    public LinkedList() {
        this.size = 0;
    }

    class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void addLast(int data) {
        Node node = new Node(data, null);
        if (this.tail == null) {
            this.tail = this.head = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    public void print() {
        Node node = this.head;
        while (node != null) {
            System.out.print(node.data + ", ");
            node = node.next;
        }
        System.out.println();
    }

    public Node getAt(int idx) {
        if (idx < 0 || idx >= this.size) {
            System.out.println("Invalid input");
            return null;
        }
        int i = 0;
        Node n = this.head;
        while (i < idx) {
            i++;
            n = n.next;
        }
        return n;
    }

    public Node removeLast() {
        Node node = getAt(this.size - 2);
        Node res = this.tail;
        node.next = null;
        this.tail = node;
        this.size--;
        return res;
    }
}
