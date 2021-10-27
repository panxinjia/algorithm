package com.xiaopan.array;

import com.xiaopan.inter.List;

/**
 * 动态数组
 * @param <E> 元素类型
 *
 * @author xiaopantx
 */
public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private E[] data;
    private int size;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        // 创建泛型数组
        this.data = (E[])new Object[capacity];
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void addFirst(E e) {

    }

    @Override
    public void addLast(E e) {

    }

    @Override
    public void add(int index, E e) {
        // 添加范围 [0, size]
        if (index < 0 || index > size) {
            throw new IllegalArgumentException(String.format("index out of range, must between %d and %d", 0, size));
        }


    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E remove(E e) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public void update(int index, E e) {

    }

    @Override
    public E get(int index) {

        return null;
    }

    @Override
    public int find(E e) {
        return 0;
    }

    /**
     * 保证容量 & 保证空间利用率
     * @param newCapacity 新的容量大小
     */
    public void resize(int newCapacity) {
        //TODO 数组扩缩容
    }


}
