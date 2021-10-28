package com.xiaopan.linked;

/**
 * 链表结构
 * @param <E>
 */
public class LinkedList<E> {

    // private Node<E> head;
    private Node<E> dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node<E>(null, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

//    头部添加
    public void addFirst(E e) {
//        Node node = new Node(e, null);
//        node.next = head;
//        head = node;

//        head = new Node<E>(e, head);
//        size++;

        add(0, e);
    }

//    尾部添加
    public void addLast(E e) {
        add(size, e);
    }

//    链表指定位置添加
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("array is full, add fail");
        }

        // index = 0, 在头部添加需要特殊处理
//        if (index == 0) {
//            addFirst(e);
//        }else {
//            Node<E> prev = head;
//            for (int i = 0; i < index - 1; i++) {
//                prev = prev.next;
//            }
//             链接链表节点
//            prev.next = new Node<E>(e, prev.next);
//            size++;
//        }

//        添加虚拟节点
        Node<E> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node<E>(e, prev.next);
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException(String.format("index must be [%s, %s]", 0, size - 1));
        }

        Node<E> curr = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.value;
    }

    public E getFirst(int index) {
        return get(0);
    }

    public E getLast(int index) {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException(String.format("index must be [%s, %s]", 0, size - 1));
        }

        Node<E> curr = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        curr.value = e;
    }

    // 是否包含元素
    public boolean contains(E e) {
        Node<E> curr = dummyHead.next;
        while (curr != null) {
            if (curr.value.equals(e)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    /**
     * 删除节点
     * @param index 删除指定位置的节点
     * @return 删除的节点值
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException(String.format("index must be [%s, %s]", 0, size - 1));
        }

        Node<E> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node<E> delNode = prev.next;
        prev.next = delNode.next;
        return delNode.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("head[ ");
        for(Node<E> curr = dummyHead.next; curr != null; curr = curr.next) {
            sb.append(curr.value + " -> ");
        }
        sb.append("NULL ] tail.");
        return sb.toString();
    }

    class Node<E> {
        private E value;
        private Node next;

        public Node() {
        }

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
