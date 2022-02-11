package com.xiaopan.stack;

import com.xiaopan.arr.Array;
import com.xiaopan.intr.Stack;

/**
 * @author xiaopantx
 * @version 1.0
 * @description 动态数组实现栈结构
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> data;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int capacity) {
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
    public void push(E e) {
        data.addLast(e);
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public E peek() {
        return data.getLast();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("stack: [");
        for (int i = 0; i < data.size(); i++) {
            sb.append(data.get(i));
            if (i != data.size() - 1)
                sb.append(", ");
        }

        sb.append("] top");

        return sb.toString();
    }
}
