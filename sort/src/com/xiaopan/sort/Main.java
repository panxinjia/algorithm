package com.xiaopan.sort;

import com.xiaopan.sort.tools.ArrayGenerator;
import com.xiaopan.sort.tools.SortHelper;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;

/**
 * @author xiaopantx
 * @version 1.0
 * @description TODO
 */
public class Main {

    private static final Random RANDOM = new Random();


    public static void main(String[] args) {
        List<Integer> ints = RANDOM.ints(100)
                .boxed()
                .toList();

        System.out.println(ints);

        ints = RANDOM.ints(100, 1, 100)
                .boxed()
                .toList();

        System.out.println(ints);

        List<Double> dbs = RANDOM.doubles(100, 1.0, 100.0)
                .boxed()
                .toList();

        System.out.println(dbs);

        System.out.println("<-------------------------------->");


        int[] arr = {1, 4, 11, 5, 6, 2, 4, 3};
        System.out.println(Arrays.toString(arr));
        int[] dest = Main.selectionSort(arr);
        System.out.println(Arrays.toString(dest));

        System.out.println("<---------------原地选择排序----------------->");

        Integer[] src = ArrayGenerator.generatorRandomArray(100, 100);
        System.out.println(Arrays.toString(src));
        Main.selectSortReverse(src);
        System.out.println((SortHelper.isSorted(src) ? " 排序完成 " : " 排序失败 ") + ", " + Arrays.toString(src));

        System.out.println("<----------------插入排序---------------->");
        Integer[] data = ArrayGenerator.generatorRandomArray(100, 100);
        System.out.println(Arrays.toString(data));
        //Main.insertSort(data);
        Main.insertSortReverse(data);
        System.out.println((SortHelper.isSorted(data) ? " 排序完成 " : " 排序失败 ") + ", " + Arrays.toString(src));

    }

    /**
     * 排序会修改掉原来的数组
     *
     * @param ints 排序的数组
     * @return 新数组
     */
    public static int[] selectionSort(int[] ints) {
        if (ints == null || ints.length < 2)
            return ints;

        int len = ints.length;
        int[] dest = new int[ints.length];

        // 新数组是否[0-i)之间已经处理完成
        for (int i = 0; i < len; i++) {
            // 下一个最小值
            int next = 0;
            for (int j = 0; j < len; j++) {
                if (ints[next] > ints[j]) {
                    next = j;
                }
            }

            dest[i] = ints[next];
            // 选择最小值之后将元素置为最大
            ints[next] = Integer.MAX_VALUE;
        }
        return dest;
    }

    /**
     * 原地选择排序
     *
     * @param data
     * @param <E>
     */
    public static <E extends Comparable> void selectSort(E[] data) {
        if (data == null || data.length < 2) {
            return;
        }

        int len = data.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = min + 1; j < len; j++) {
                if (data[j].compareTo(data[min]) < 0)
                    min = j;
            }
            // 每次交换一个最小值
            SortHelper.swap(data, i, min);
        }
    }

    // 选择排序, 倒序处理
    public static <E extends Comparable> void selectSortReverse(E[] data) {
        if (data == null || data.length < 2) {
            return;
        }

        int len = data.length;
        for (int i = len - 1; i >= 0; i--) {
            int max = i;
            for (int j = max - 1; j >= 0; j--) {
                if (data[j].compareTo(data[max]) > 0)
                    max = j;
            }
            SortHelper.swap(data, i, max);
        }

    }

    // 插入排序,  头插
    public static <E extends Comparable> void insertSort(E[] data) {
        if (data == null || data.length < 2) {
            return;
        }

        int len = data.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j > 0 && data[j].compareTo(data[j - 1]) < 0; j--) {
                SortHelper.swap(data, j, j - 1);
            }
        }

    }

    // 尾插
    public static <E extends Comparable> void insertSortReverse(E[] data) {
        if (data == null || data.length < 2) {
            return;
        }

        int len = data.length - 1;
        for (int i = len; i >= 0; i--) {
            for (int j = i; j > len && data[j].compareTo(data[j + 1]) < 0; j++) {
                SortHelper.swap(data,j, j+1);
            }
        }
    }
}
