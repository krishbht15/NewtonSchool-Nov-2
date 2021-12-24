package com.company.dec23_24;

import sun.security.krb5.internal.crypto.ArcFourHmacEType;

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
        if (this.size == 0) {
            System.out.println("Invalid operation");
            return null;
        }
        Node node = getAt(this.size - 2);
        Node res = this.tail;
        node.next = null;
        this.tail = node;
        this.size--;
        return res;
    }

    public void addFirst(int data) {
        Node node = new Node(data, null);
        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
            this.size++;
        }
    }

    public Node removeFirst() {
        if (this.size == 0) {
            System.out.println("Invalid operation");
            return null;
        }
        Node res = this.head;
        this.size--;
        this.head = this.head.next;
        res.next = null;
        return res;
    }

    public void addAt(int idx, int data) {
        if (idx < 0 || idx > this.size) {
            System.out.println("Invalid operation");
        } else if (idx == 0) addFirst(data);
        else if (idx == this.size) addLast(data);
        else {
            Node prevNode = getAt(idx - 1);
            Node node = new Node(data, null);
            node.next = prevNode.next;
            prevNode.next = node;
            this.size++;
        }
    }

    public Node removeAt(int idx) {
        if (this.size == 0) {
            System.out.println("Invalid operation.");
            return null;
        } else if (idx < 0 || idx >= this.size) {
            System.out.println("Invalid index");
            return null;
        } else if (idx == 0) return removeFirst();
        else if (idx == this.size - 1) return removeLast();
        Node prev = getAt(idx - 1);
        Node res = prev.next;
        prev.next = prev.next.next;
        res.next = null;
        this.size--;
        return res;
    }

    public Node getFirstMid() {
        Node s = this.head;
        Node f = this.head;
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    public Node getSecondMid() {
        Node s = this.head;
        Node f = this.head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
}
