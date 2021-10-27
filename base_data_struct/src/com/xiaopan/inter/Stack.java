package com.xiaopan.inter;

public interface Stack<E> {

    void push(E e);

    E pop();

    E peek();

    E peek(int index);

    int size();

    boolean isEmpty();
}
