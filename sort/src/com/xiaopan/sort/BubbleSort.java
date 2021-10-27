package com.xiaopan.sort;

import com.xiaopan.sort.tools.ArrayGenerator;
import com.xiaopan.sort.tools.SortHelper;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 冒泡排序算法
 */
public class BubbleSort {

    private BubbleSort() {

    }

    public static <E extends Comparable<E>> void genericSort(E[] data) {
        if (data == null || data.length < 2) {
            return;
        }
        for (int i = 0; i < data.length; i++) {
            for(int j = 0; j < data.length - i -1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    SortHelper.swap(data, j, j + 1);
                }
            }
        }

    }

    public static void main(String[] args) {
        Integer[] data = ArrayGenerator.generatorRandomArray(10, 100);
        System.out.println(Arrays.toString(data));
        genericSort(data);
        System.out.println(Arrays.toString(data));


    }
}
