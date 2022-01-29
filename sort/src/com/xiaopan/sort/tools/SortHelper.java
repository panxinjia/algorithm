package com.xiaopan.sort.tools;

import com.xiaopan.sort.BubbleSort;
import com.xiaopan.sort.InsertionSort;
import com.xiaopan.sort.MergerSort;
import com.xiaopan.sort.SelectionSort;

import java.util.Arrays;

public class SortHelper {

    /**
     * 数组元素位置
     * @param data 数组
     * @param m
     * @param n
     * @param <E> 泛型参数
     */
    public static <E> void swap(E[] data, int m, int n) {
        E tmp = data[m];
        data[m] = data[n];
        data[n] = tmp;
    }

    public static void swap(int[] data, int m, int n) {
        int temp = data[m];
        data[m] = data[n];
        data[n] = temp;
    }

    public static <E> void printArray(E[] data) {
        System.out.println(Arrays.toString(data));
    }

    public static void printArray(int[] data) {
        System.out.println(Arrays.toString(data));
    }


    /**
     * 数组是否排序完成
     * @param data 数组
     * @param <E> 元素类型
     * @return 是否排序完成
     */
    public static <E extends Comparable<E>> boolean isSorted(E[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i - 1].compareTo(data[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 排序算法性能测试
     * @param sortType 算法类型
     * @param data 数组
     * @param <E> 数组元素类型
     */
    public static <E extends Comparable<E>> void sortTest(SortType sortType, E[] data) {
        long start = System.nanoTime();
        switch (sortType) {
            case SELECTION_SORT -> SelectionSort.genericSort(data);
            case INSERTION_SORT -> InsertionSort.genericSort(data);
            case BUBBLE_SORT -> BubbleSort.genericSort(data);
            case MERGER_SORT -> MergerSort.mergerSortGeneric(data);
            default -> System.out.println("没有这种排序算法");
        }
        long end = System.nanoTime();
        double time = (end - start) / 1000_000_000.0;
        if (!isSorted(data)) {
            throw new RuntimeException("数值正排序失败~");
        }
        System.out.printf("排序算法:[%s],数据规模:[%d], 运行时间:[%.4f]秒%n",
                sortType.getSortName(), data.length, time);
    }
}
