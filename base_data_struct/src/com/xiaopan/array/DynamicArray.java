package com.xiaopan.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author xiaopantx
 * @version 1.0
 * @description
 */
public class DynamicArray<E> {

    private static final int DEFAULT_SIZE = 10;

    private E[] data;
    private int size;

    public DynamicArray(int capacity) {
        if (capacity < 0) {
            IllegalArgumentException e = new IllegalArgumentException("capacity 初始空间必须大于 0");
        }else if (capacity == 0) {
            data = (E[]) new Object[0];
        }else {
            data = (E[]) new Object[capacity];
        }
        size = 0;
    }

    public DynamicArray() {
        this(DEFAULT_SIZE);
    }

    public int capacity() {
        return this.data.length;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addLast(E element) {
        add(element, size);
    }

    public void addFirst(E element) {
        add(element, 0);
    }

    public void add(E element, int index) {
//        if (size == capacity())
//            throw new IllegalArgumentException("Add Fail, Array is full");

        checkIndexRange(index,size);

//        延迟扩容, 添加时如果容量不够才进行扩容, jdk api 每次扩容1.5倍
        if (size == capacity()) {
            resize(data.length * 2);
        }


        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        // api 拷贝
        // System.arraycopy(data,index, data, index + 1, size - index);

        data[index] = element;
        size++;


    }

    public int find(E element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(data[i],element))
                return i;
        }
        return -1;
    }

    public int[] findAll(int element) {
        IntStream.Builder builder = IntStream.builder();
        for (int i = 0; i < size; i++) {
            if (Objects.equals(data[i],element))
                builder.add(i);
        }
        return builder.build().toArray();
    }

    public E get(int index) {
        checkIndexRange(index,size - 1);
        return data[index];
    }

    public void set(E element, int index) {
        checkIndexRange(index,size - 1);
        data[index] = element;
    }

    public E remove(int index) {
        checkIndexRange(index,size - 1);
        E element = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        // 移除元素断开引用, gc尽快回收内存
        data[size] = null;
        size--;

        if (size == (capacity() / 2)) {
            resize(capacity() - (capacity() / 4));
        }

        return element;
    }

    public void removeElement(E element) {
        int index = find(element);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 移除所有目标元素
     * @param element 目标元素
     * @return 移除目标元素结果
     */
    public Object[] removeAll(E element) {
        Stream.Builder<E> builder = Stream.<E>builder();
        int index = -1;
        while ((index = find(element)) != -1) {
            E ele = remove(index);
            builder.add(ele);
        }
        return builder.build().toArray();
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        line.append(String.format("Array: size = %d, capacity = %d\n", size, capacity()));
        line.append('[');
        for (int i = 0; i < size; i++) {
            line.append(data[i]);
            if (i != size - 1)
                line.append(", ");
        }
        line.append(']');
        return line.toString();
    }

    private void checkIndexRange(int index, int bound) {
        if (index < 0 || index > bound) {
            throw new IllegalArgumentException(String.format("index = %d 超过访问边界[%d, %d]", index, 0, bound));
        }
    }

    /**
     * 动态数组, 支持扩容和缩容, 这种操作要注意, 防止复杂度震荡, 将扩缩容动作均摊到添加和移除上
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity) {
        this.data = Arrays.copyOf(this.data, newCapacity);
    }
}
