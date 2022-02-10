package com.xiaopan.sort;

import com.xiaopan.sort.tools.ArrayGenerator;
import com.xiaopan.sort.tools.SortHelper;
import com.xiaopan.sort.tools.SortType;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * @author xiaopantx
 * @version 1.0
 * @description 选择, 插入, 冒泡, 归并
 */
public class Main {

    private static final Random RANDOM = new Random();


    public static void main(String[] args) {

//        测试选择排序
//        int[] arr = new int[]{1, 10, 2, 9, 44, 8};
//        SortHelper.printArray(arr);
//        // selectionSort(arr);
//        selectionSortReverse(arr);
//        SortHelper.printArray(arr);
//
//        System.out.println("<-------------------------------->");
//
//        Integer[] data = RANDOM.ints(100, 1, 100)
//                .boxed()
//                .toArray(Integer[]::new);
//
//        SortHelper.printArray(data);
//        selectionSort(data);
////        selectionSortReverse(data);
//        SortHelper.printArray(data);

//        测试插入排序 --> 理解选择排序和插入排序的特点
//        int[] dataSize = {10000, 10_0000};
//        for (int size: dataSize) {
//            Integer[] data =
//                    // 无序数组插入排序
//                     ArrayGenerator.generatorRandomArray(size,size);
//                    // 有序数组插入排序
//                    // ArrayGenerator.generatorOrderedArray(size);
//            long start = System.nanoTime();
//            insertionSortReverse(data);
//            long end = System.nanoTime();
//            double time = (end - start) / 1000_000_000.0;
//
//            SortHelper.isSorted(data);
//
//            // 插入排序, 时间复杂度为O(n^2), 有序数组不需要很多交换和比较, 速度非常快
//            String format = String.format("数据规模 [%d], 运行时间 [%f] 秒", size, time);
//            System.out.println(format);
//        }

//        Integer[] data = new Random().ints(100, 0, 100).boxed().toArray(Integer[]::new);
//        System.out.println(Arrays.toString(data));
//        insertionSort(data);
//        System.out.println(Arrays.toString(data));


        Integer[] array = new Random().ints(10, 1, 10)
                .boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));

    }

    // 冒泡排序
    public static <E extends Comparable<E>> void bubbleSort(E[] data) {
        if (data == null || data.length < 2)
            return;
        int len = data.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len - i; j++) {
                if (data[j].compareTo(data[j - 1]) < 0)
                    SortHelper.swap(data, j, j - 1);
            }
        }
    }

    // 插入排序, 正向
    public static <E extends Comparable<E>> void insertionSort(E[] data) {
        if (data == null || data.length < 2)
            return;

        /*
        int len = data.length;
        //循环不变量: [0-i) 之间有序, [i, len) 之间无序
        for (int i = 0; i < len; i++) {
            //循环不变量:  data[j] < data[j-1] && j - 1 >= 0
            for (int j = i, pre = j - 1; pre >= 0 && data[j].compareTo(data[pre]) < 0; j--, pre--) {
                SortHelper.swap(data,pre,j);
            }
        }
        */
        int len = data.length;
        for (int i = 0; i < len; i++) {
            E val = data[i];
            int j = i;
            // 插入排序优化, 减少交换次数, 直接赋值, 最终位置交换
            while (j > 0 && val.compareTo(data[j - 1]) < 0) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = val;
        }
    }

    // 插入排序, 倒插
    public static <E extends Comparable<E>> void insertionSortReverse(E[] data) {
        if (data == null || data.length < 2)
            return;

//        int len = data.length;
//        for (int i = len - 1; i >= 0; i--) {
//            for (int j = i, pre = j + 1; pre <= len - 1 && data[j].compareTo(data[pre]) > 0; j++, pre++) {
//                SortHelper.swap(data,j, pre);
//            }
//        }

        // 优化版本
        int len = data.length;
        for (int i = len - 1; i >= 0; i--) {
            E val = data[i];
            int j = i;
            while (j + 1 <= len - 1 && val.compareTo(data[j + 1]) > 0) {
                data[j] = data[j + 1];
                j++;
            }
            data[j] = val;
        }
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
