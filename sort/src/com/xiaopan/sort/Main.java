package com.xiaopan.sort;

import com.xiaopan.sort.tools.ArrayGenerator;
import com.xiaopan.sort.tools.SortHelper;
import com.xiaopan.sort.tools.SortType;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;

/**
 * @author xiaopantx
 * @version 1.0
 * @description 选择, 插入, 冒泡, 归并
 */
public class Main {

    private static final Random RANDOM = new Random();


    public static void main(String[] args) {
        int[] arr = new int[]{1, 10, 2, 9, 44, 8};
        SortHelper.printArray(arr);
        // selectionSort(arr);
        selectionSortReverse(arr);
        SortHelper.printArray(arr);

        System.out.println("<-------------------------------->");

        Integer[] data = RANDOM.ints(100, 1, 100)
                .boxed()
                .toArray(Integer[]::new);

        SortHelper.printArray(data);
        selectionSort(data);
//        selectionSortReverse(data);
        SortHelper.printArray(data);

    }

    // <--------- 选择排序, 正排序, 倒排序 --------->
    // 选择, 数组正排
    public static void selectionSort(int[] data) {
        if (data == null || data.length < 2)
            return;

        int len = data.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i; j < len; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }
            int temp = data[min];
            data[min] = data[i];
            data[i] = temp;
        }
    }

    // 选择, 数组倒排
    public static void selectionSortReverse(int[] data) {
        if (data == null || data.length < 2)
            return;

        int len = data.length;
        for (int i = len - 1; i >= 0; i--) {
            int max = i;
            for (int j = 0; j < i; j++) {
                if (data[j] < data[max])
                    max = j;
            }
            SortHelper.swap(data, max, i);
        }

    }

    // 选择, 泛型正排
    public static <E extends Comparable<E>> void selectionSort(E[] data) {
        if (data == null || data.length < 2)
            return;

        int len = data.length;
        for (int i = 0; i < len; i ++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                // 明确定义比较元素
                if (data[j].compareTo(data[min]) < 0)
                    min = j;
            }
            SortHelper.swap(data,min, i);

        }
    }

    // 选择, 泛型倒排
    public static <E extends Comparable> void selectionSortReverse(E[] data) {
        if (data == null || data.length < 2)
            return;
        int len = data.length - 1;
        for (int i = len; i >= 0; i--) {
            int min = i;
            for (int j = i - 1; j >= 0; j--) {
                if (data[j].compareTo(data[min]) < 0)
                    min = j;
            }

            SortHelper.swap(data,min,i);
        }
    }


}
