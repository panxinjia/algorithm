package com.xiaopan.link;

import org.w3c.dom.Node;

import java.awt.geom.Line2D;

/**
 * @author xiaopantx
 * @version 1.0
 * @description 单向链表实现
 * 1. 指针/索引的操作
 * 2. 链表递归
 */
public class LinkedList<E> {

    private Node<E> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // 头部添加元素
    public void addFirst(E val) {
        head = new Node(val, head);
        size++;
    }

    // 添加元素到链表指定位置
    public void add(E val, int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add fail illegal index");

        if (index == 0) {
            head = new Node<>(val, head.next);
            size++;
            return;
        }

        Node<E> prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }

        prev.next = new Node(val, prev.next);
        size++;
    }

    // 添加到链表尾部
    public void addLast(E val) {
        add(val, size);
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("get fail illegal index");

        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.val;
    }

    public E set(E val, int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("get fail illegal index");
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        E retVal = cur.val;
        cur.val = val;
        return retVal;
    }

    public void remove(E e) {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("linkedList head : ");
        // TODO 链表的边界问题
        for (Node<E> cur = head; cur != null; cur = cur.next) {
            sb.append(cur.val).append(" -> ");
        }
        sb.append("NULL");
        return sb.toString();
    }

    private class Node<E> {
        private E val;
        private Node next;

        public Node() {
            this(null, null);
        }

        public Node(E val) {
            this(val, null);
        }

        public Node(E val, Node next) {
            this.val = val;
            this.next = next;
        }

        public E getVal() {
            return val;
        }

        public void setVal(E val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return val.toString();
        }
    }


    public static void main(String[] args) {
        LinkedList<Integer> link = new LinkedList<>();

        link.addFirst(1);
        link.addLast(2);
        link.addFirst(3);
        for (int i = 21; i< 26; i++)
            link.add(i, 2);
        // System.out.println(link.size() + " " + link.isEmpty() + " " + link);
        System.out.println(link);

    }
}
