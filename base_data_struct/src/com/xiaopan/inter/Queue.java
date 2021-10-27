package com.xiaopan.inter;

public interface Queue<E> {

    void enQueue(E e);
    E deQueue();

    int size();

    boolean isEmpty();
}
