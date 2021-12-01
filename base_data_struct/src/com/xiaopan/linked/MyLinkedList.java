package com.xiaopan.linked;

import java.util.StringJoiner;

/**
 * @author xiaopantx
 * @version 1.0
 * @description 特征: 1.动态  2.指针 3. 深刻理解递归特性
 *
 * 1. 深入理解链表特性
 * 2. 链表 增加, 删除, 边界值处理的问题, 理解逻辑上的差别
 * 3. dummyHead 处理技巧
 */
public class MyLinkedList<E> {

    // 虚拟头节点, 对于用户是不存在的, 数据结构特殊位置添节点, 以便处理通用逻辑
    private Node dummyHead;

    private Node first;
    private int size;

    public MyLinkedList() {

        //TODO 处理 dummyHead 节点
        dummyHead = new Node(null,first);
        first = null;
        size = 0;
    }

    public void addFirst(E e) {
        first = new Node(e, first);
        size++;
    }

    public void add(int index, E e) {
        checkIndexRange(index, size);

        if (index == 0)
            addFirst(e);
        else {
            Node prev = first;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }

            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    public void addLast(E e) {
//        Node curr = first;
//        while (curr != null && curr.next != null)
//            curr = curr.next;
//        curr.next = new Node(e,null);
        add(size, e);
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public E get(int index) {
        checkIndexRange(index, size - 1);
        Node curr = first;
        int pos = 0;
        while (curr != null && curr.next != null && pos < index) {
            curr = curr.next;
            pos++;
        }
        return curr == null ? null : curr.value;
    }

    public E set(int index, E e) {
        checkIndexRange(index, size - 1);
        if (first == null)
            return null;

        Node curr = first;
        for (int i = 0; i < index && curr.next != null; i++) {
            curr = first.next;
        }

        E val = curr.value;
        curr.value = e;
        return val;
    }

    public E removeFirst() {
        if (first == null)
            return null;

        E e = first.value;
        first = first.next;
        size--;
        return e;
    }

    public E removeLast() {
        Node curr = first;
        int pos = 0;
        while (curr != null && curr.next != null && pos != size - 2) {
            curr = curr.next;
            pos++;
        }
        E e = curr.next.value;
        curr.next = null;
        size--;
        return e;
    }

    //TODO remove 链表移除方法
    public  E remove(int index) {
        checkIndexRange(index, size - 1);
        if (index == 0) {
            E e = first.value;
            size--;
            return e;
        }

        Node prev = first;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }

        E e = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return e;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        line.append("链表(size = " + size + "): ");
        Node curr = first;
        while (curr != null) {
            E value = curr.value;
            line.append(value);
            curr = curr.next;

            if (curr != null) {
                line.append(" -> ");
            }
        }
        return line.toString();
    }

    private void checkIndexRange(int index, int bound) {
        if (index < 0 || index > bound) {
            throw new IllegalArgumentException(String.format("索引 index = %d, 访问越界 [%d, %d]", index, 0, bound));
        }

    }

    private class Node {
        public E value;
        public Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(E value) {
            this(value, null);
        }

        public Node(Node next) {
            this(null, next);
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
