package com.xiaopan.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.xiaopan.sort.bean.Student;
import com.xiaopan.sort.tools.ArrayGenerator;
import com.xiaopan.sort.tools.SortHelper;
import com.xiaopan.sort.tools.SortType;

/**
 * 选择排序
 *
 * @author xiaopan
 */
public class SelectionSort {
    private SelectionSort() {
    }

    /**
     * 额外空间选择排序
     *
     * @param data 排序数组
     * @return 排序结果
     */
    public static Integer[] sortWithCopy(Integer[] data) {
        Integer[] result = new Integer[data.length];
        for (int i = 0; i < result.length; i++) {
            int minIndex = 0;
            for (int j = 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            result[i] = data[minIndex];
            data = compact(data, minIndex);
        }
        return result;
    }


    /**
     * 正排序
     *
     * @param data 排序数组
     * @return 排序结果
     */
    public static Integer[] sort(Integer[] data) {
        if (data == null || data.length < 2)
            return data;

        int N = data.length;
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i; j < N; j++) {
                if (data[j] < data[minIndex])
                    minIndex = j;
            }
            SortHelper.swap(data, i, minIndex);
        }
        return data;
    }

    /**
     * 倒排序
     *
     * @param data 排序数组
     * @return
     */
    public static Integer[] reverseSort(Integer[] data) {
        if (data == null || data.length < 2)
            return data;

        int N = data.length - 1;
        for (int i = N; i >= 0; i--) {
            int maxIndex = i;
            for (int j = i; j >= 0; j--) {
                if (data[j] > data[maxIndex])
                    maxIndex = j;
            }
            SortHelper.swap(data, i, maxIndex);
        }
        return data;
    }

    /**
     * 泛型选择排序
     *
     * @param data 排序数组
     * @param <E>  元素类型
     */
    public static <E extends Comparable<E>> void genericSort(E[] data) {
        if (data == null || data.length < 2)
            return;

        int N = data.length - 1;
        // 循环不变量 在[i, N]之间无序, 在[0,i)之间有序 需要排列
        for (int i = 0; i <= N; i++) {
            int minIndex = i;
            //循环不变量 从[i,N]之间找到最小的元素 和 i 交换是否完成
            for (int j = i; j <= N; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            SortHelper.swap(data, i, minIndex);
        }
    }

    /**
     * 比较选择排序
     * @param data 数组
     * @param comparator 比较器
     * @param <E> 泛型参数
     */
    public static <E> void genericSort(E[] data, Comparator<E> comparator) {
        if (data == null || data.length < 2) {
            return;
        }
        int N = data.length;
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i; j < N; j++) {
                if (comparator.compare(data[j], data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            SortHelper.swap(data, i, minIndex);
        }
    }

    private static Integer[] compact(Integer[] data, int index) {
        Integer[] compactResult = new Integer[data.length - 1];
        // 元素复制
        System.arraycopy(data, 0, compactResult, 0, index);
        System.arraycopy(data, index + 1, compactResult, index, data.length - (index + 1));
        return compactResult;
    }


    public static void main(String[] args) {

        System.out.println("-------->测试性能<----------");
        int[] dataSize = {10000, 10_0000};
        for (int i = 0; i < dataSize.length; i++) {
            Integer[] data = ArrayGenerator.generatorRandomArray(dataSize[i], dataSize[i]);
            SortHelper.sortTest(SortType.SELECTION_SORT, data);
        }

    }
}
