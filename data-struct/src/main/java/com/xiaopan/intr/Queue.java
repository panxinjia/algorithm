package com.xiaopan.intr;

public interface Queue<E> {

    public int size();
    public boolean isEmpty();
    // 入队
    public void enqueue(E e);
    // 出队
    public E dequeue();
    // 查看队首元素
    public E front();
}
