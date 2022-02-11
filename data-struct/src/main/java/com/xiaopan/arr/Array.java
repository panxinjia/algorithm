package com.xiaopan.arr;

/**
 * @author xiaopantx
 * @version 1.0
 * @description 封装动态数组
 */
public class Array<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private E[] data;
    private int size;

    public Array() {
        this(DEFAULT_CAPACITY);
    }

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity() {
        return data.length;
    }

    public void add(E e, int index) {
        // 容量不够时进行扩容
        if (size == data.length) {
            resize(data.length * 2);
        }

        // 检查索引
        checkRange(index, 0, size);


        // 移动元素
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    public void addFirst(E e) {
        add(e, 0);
    }

    public void addLast(E e) {
        add(e, size);
    }

    public E get(int index) {
        checkRange(index, 0, size - 1);
        return data[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    public void set(E e, int index) {
        checkRange(index, 0, size - 1);
        data[index] = e;
    }

    public E remove(E e) {
        int idx = find(e);
        if (idx != -1) {
            return remove(idx);
        }
        return null;
    }

    public void removeAll(E e) {
        int cnt = 0;
        // 元素e的个数
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                cnt++;
        }

        if (cnt == 0)
            return;
        E[] newData = (E[]) new Object[data.length];
        for (int i = 0, pos = 0; i < size; i++) {
            if (data[i].equals(e))
                continue;
            newData[pos] = data[i];
            pos++;
        }
        data = newData;
        size -= cnt;
    }

    public E remove(int index) {
        checkRange(index, 0, size - 1);
        E e = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        data[size - 1] = null;
        size--;

        // 当前size 只有容量的1/4时, 缩容一半
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);

        return e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    // 一次移除多个元素
    public void remove(E ... e) {
        for (E val : e) {
            remove(val);
        }
    }

    // 检查索引边界, [l, r]
    private void checkRange(int index, int l, int r) {
        if (index < l || index > r)
            throw new IllegalArgumentException(String.format("op fail, out of range(%d, %d)", l, r));
    }

    /**
     * 扩容缩容操作
     * 每次扩容一倍
     * 每次缩容1/4
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        // 现有元素全部为空, 其余为默认值
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Array: size = ").append(size())
                .append(", capacity = ").append(getCapacity()).append("\n");
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

}
