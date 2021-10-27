package com.xiaopan.inter;

/**
 * 数组线性表接口
 *
 * @param <E> 泛型参数
 */
public interface List<E> {

    boolean isEmpty();
    int size();

    void addFirst(E e);
    void addLast(E e);
    void add(int index, E e);

    E removeFirst();
    E removeLast();
    E remove(E e);
    E remove(int index);

    void update(int index, E e);

    int find(E e);

    E get(int index);


}
