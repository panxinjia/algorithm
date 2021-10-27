package com.xiaopan.queue;

import com.xiaopan.inter.Queue;

public class LoopQueue<E> implements Queue<E> {
    @Override
    public void enQueue(E e) {

    }

    @Override
    public E deQueue() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
