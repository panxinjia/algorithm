package com.xiaopan.queue;

import com.xiaopan.arr.Array;
import com.xiaopan.intr.Queue;

/**
 * @author xiaopantx
 * @version 1.0
 * @description
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> data;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int capacity) {
        data = new Array<>(capacity);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    @Override
    public E dequeue() {
        return data.removeFirst();
    }

    @Override
    public E front() {
        return data.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("queue: head[");
        for (int i= 0; i < data.size(); i++) {
            sb.append(data.get(i));
            if (i != data.size() - 1)
                sb.append(", ");
        }

        sb.append("] tail");
        return sb.toString();
    }
}
