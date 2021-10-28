package com.xiaopan.array;

import com.xiaopan.inter.List;

import java.util.Arrays;

/**
 * 动态数组
 * @param <E> 元素类型
 *
 * @author xiaopantx
 */
public class ArrayList<E> implements List<E> {

    /**
     * 默认空间大小
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 保存元素的数组
     */
    private E[] data;

    /**
     * 容器中元素的个数
     */
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
        add(0, e);
    }

    @Override
    public void addLast(E e) {
        add(size, e);
    }

    @Override
    public void add(int index, E e) {

        // 检查数组容量, 不够时扩容
        if (size == data.length) {
            // 扩容, 基数原来容量的2倍
            resize(data.length * 2);
        }

        // 添加范围 [0, size], 包含size但不能超越size, 不能间隔保存元素
//        if (index < 0 || index > size) {
//            throw new IllegalArgumentException(String.format("index out of range, must [%d,%d]", 0, size));
//        }
        this.checkRange(index, 0, size + 1);

        // 拷贝元素
        for(int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = e;
        size++;
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
//        if (index < 0 || index >= size) {
//            throw new IllegalArgumentException(String.format("index out of range, must [%d, %d)", 0, size));
//        }
        this.checkRange(index);
        return this.data[index];
    }

    @Override
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (this.data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * 保证容量 & 保证空间利用率
     * @param newCapacity 新的容量大小
     */
    public void resize(int newCapacity) {
        // 新数组
        E[] newData = (E[])new Object[newCapacity];

        // 内容拷贝
        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[i];
        }
        // 替换旧数组
        this.data = newData;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    private void checkRange(int index) {
        // 除添加外, 查找,获取,更新,删除可用的索引值
        this.checkRange(index, 0, size - 1);
    }

    /**
     * 索引边界检查, 检查范围[left, right]
     * @param index 索引
     * @param left 左边界
     * @param right 右边界
     */
    private void checkRange(int index, int left, int right) {
        if (index < left || index > right) {
            throw new IllegalArgumentException(String.format("index out of range, must [%d,%d]", left, right));
        }
    }
}
