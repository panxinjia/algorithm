package com.xiaopan.sort;

import com.xiaopan.sort.tools.ArrayGenerator;
import com.xiaopan.sort.tools.SortHelper;
import com.xiaopan.sort.tools.SortType;

import java.util.Arrays;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author xiaopantx
 * @version 1.0
 * @description 归并排序, 递归的理解和引用
 */
public class MergerSort {

    private MergerSort() {

    }

    public static void mergerSort(int[] data, int left, int right) {
        if (left >= right)
            return;

        int mid = (left + right) / 2;
        mergerSort(data, left, mid);
        mergerSort(data, mid + 1, right);
        merge(data, left, mid, right);
    }

    // 完成归并
    public static void merge(int[] data, int left, int mid, int right) {
        int[] copyData = Arrays.copyOfRange(data, left, right + 1);

        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                data[k] = copyData[j - left];
                j++;
            } else if (j > right) {
                data[k] = copyData[i - left];
                i++;
            } else if (copyData[i - left] <= copyData[j - left]) {
                data[k] = copyData[i - left];
                i++;
            } else {
                data[k] = copyData[j - left];
                j++;
            }
        }
    }

    public static <E extends Comparable<E>> void mergerSortGeneric(E[] data) {
        mergerSortGeneric(data,0, data.length - 1);
    }

    public static <E extends Comparable<E>> void mergerSortGeneric(E[] data, int left, int right) {
        if (left >= right)
            return;

        int mid = (left + right) / 2; // 整型可能会造成溢出
        mid = left + (right - left) / 2; // 解决整型可能溢出的bug, todo 数据边界的通用计算方式
        mergerSortGeneric(data, left, mid);
        mergerSortGeneric(data, mid + 1, right);
        mergeGeneric(data, left, mid, right);
    }

    // 完成归并
    public static <E extends Comparable<E>> void mergeGeneric(E[] data, int left, int mid, int right) {
        E[] copyData = Arrays.copyOfRange(data, left, right + 1);

        // TODO 理解归并过程 while 改写
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                data[k] = copyData[j - left];
                j++;
            } else if (j > right) {
                data[k] = copyData[i - left];
                i++;
            } else if (copyData[i - left].compareTo(copyData[j - left]) >= 0) {
                data[k] = copyData[i - left];
                i++;
            } else {
                data[k] = copyData[j - left];
                j++;
            }
        }


    }

    public static void main(String[] args) {
        Integer[] arr = {2, 1, 4, 3};
//        mergerSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));


        Random random = new Random();
        Integer[] arr1 = random
                .ints(100_0000, 0, 100_0000)
                .boxed()
                .toArray(Integer[]::new);
        Integer[] arr2 = random
                .ints(1000_0000, 0, 1000_0000)
                .boxed()
                .toArray(Integer[]::new);

        Integer[] arr3 = random
                .ints(1_0000_0000, 0, 1_0000_0000)
                .boxed()
                .toArray(Integer[]::new);
//        Integer[] arr1 = ArrayGenerator.generatorRandomArray(100_0000, 100_0000);
//        Integer[] arr2 = ArrayGenerator.generatorRandomArray(1000_0000, 1000_0000);
//
//        System.out.println("begin");
        SortHelper.sortTest(SortType.MERGER_SORT, arr1);
        SortHelper.sortTest(SortType.MERGER_SORT, arr2);
        SortHelper.sortTest(SortType.MERGER_SORT, arr3);
//        System.out.println("end");

//        long start = System.nanoTime();
//        mergerSortGeneric(arr1, 0, arr1.length - 1);
//        long end = System.nanoTime();
//        System.out.println("数据规模 100_0000, 归并排序耗时: " + ((end - start) / (1000_000_000 / 1.0)));
//
//        start = System.nanoTime();
//        mergerSortGeneric(arr2, 0, arr2.length - 1);
//        end = System.nanoTime();
//        System.out.println("数据规模 1000_0000, 归并排序耗时: " + ((end - start) / (1000_000_000 / 1.0)));


    }
}
