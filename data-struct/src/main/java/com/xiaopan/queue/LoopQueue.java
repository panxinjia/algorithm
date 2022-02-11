package com.xiaopan.queue;

import com.xiaopan.intr.Queue;

/**
 * @author xiaopantx
 * @version 1.0
 * @description
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] date;
    private int head;
    private int tail;

    // head 和 tail 可以计算出size的值
    private int size;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enqueue(E e) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E front() {
        return null;
    }
}
