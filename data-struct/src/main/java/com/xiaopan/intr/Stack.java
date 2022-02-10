package com.xiaopan.intr;

public interface Stack<E> {

    public int size();
    public boolean isEmpty();
    // 压栈
    public void push(E e);
    // 弹栈
    public E pop();
    // 查看站定元素
    public E peek();
}
