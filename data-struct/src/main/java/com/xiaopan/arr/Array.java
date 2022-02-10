package com.xiaopan.arr;

/**
 * @author xiaopantx
 * @version 1.0
 * @description 封装动态数组
 */
public class Array<E> {

    private E[] data;
    private int size;

    public Array() {
        this(10);
    }

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public void add(E e, int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException(String.format("add fail, index out of range(%d - %d)", 0, size));

        //TODO 动态数组操作
    }

}
