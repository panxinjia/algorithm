package com.xiaopan.sort;

import com.xiaopan.sort.tools.ArrayGenerator;
import com.xiaopan.sort.tools.SortHelper;
import com.xiaopan.sort.tools.SortType;

import java.util.Arrays;

/**
 * 插入排序算法
 */
public class InsertionSort {
    private InsertionSort() {

    }

    public static void sort(Integer[] data) {
        if (data == null || data.length < 2) {
            return;
        }

        int N = data.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && data[j] < data[j - 1]; j--) {
                SortHelper.swap(data, j, j - 1);
            }
        }
    }

    public static <E extends Comparable<E>> void genericSort(E[] data) {
        if (data == null || data.length < 2) {
            return;
        }

        int N = data.length;
//        for (int i = 0; i < N; i++) {
//            for(int j = i; j > 0 && (data[j].compareTo(data[j - 1]) < 0); j--) {
//                SortHelper.swap(data, j, j - 1);
//            }
//        }

//        优化多次交换
        for (int i = 0; i < N; i++) {
            int j = i;
            E current = data[i];
            // ☆ 区分比较元素
            while (j > 0 && (current.compareTo(data[j - 1]) < 0)) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = current;

        }
    }

    public static void main(String[] args) {
        Integer[] data = ArrayGenerator.generatorRandomArray(10, 100);
        // InsertionSort.sort(data);
        System.out.println(Arrays.toString(data));
        InsertionSort.genericSort(data);
        System.out.println(Arrays.toString(data));

        System.out.println("-------->插入排序算法性能测试<----------");
        int[] dataSize = {10000, 10_0000};
        for (int i = 0; i < dataSize.length; i++) {
            Integer[] arr = ArrayGenerator.generatorRandomArray(dataSize[i], dataSize[i]);
            SortHelper.sortTest(SortType.INSERTION_SORT, arr);
        }
    }
}
