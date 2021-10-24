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
            swap(data, i, minIndex);
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
            swap(data, i, maxIndex);
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
            swap(data, i, minIndex);
        }
    }

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
            swap(data, i, minIndex);
        }
    }

    private static Integer[] compact(Integer[] data, int index) {
        Integer[] compactResult = new Integer[data.length - 1];
        // 元素复制
        System.arraycopy(data, 0, compactResult, 0, index);
        System.arraycopy(data, index + 1, compactResult, index, data.length - (index + 1));
        return compactResult;
    }

    // 交换两个元素的位置
    private static void swap(Integer[] data, int m, int n) {
        int tmp = data[m];
        data[m] = data[n];
        data[n] = tmp;
    }

    // 交换两个元素的位置
    private static <E> void swap(E[] data, int m, int n) {
        E tmp = data[m];
        data[m] = data[n];
        data[n] = tmp;
    }

    public static void main(String[] args) {

//         测试compact方法
        Integer[] arr = {1, 23, 4, 10, 5};
//        Integer[] compactResult = compact(arr, 3);
//        System.out.println(Arrays.toString(compactResult));

//         测试选择排序
        Integer[] result =
//                sortWithCopy(arr);
//                sort(arr);
                reverseSort(arr);
        System.out.println(Arrays.toString(result));

//        测试泛型排序
        arr = new Integer[]{10, 299, 87, 4, 56};
        genericSort(arr);
        System.out.println(Arrays.toString(arr));

//        测试泛型排序, 引用类型处理
        Student[] students = {
                new Student(19),
                new Student(22),
                new Student(18),
                new Student(50),
                new Student(29)
        };

//       自定义比较排序
        genericSort(students, Comparator.comparingInt(Student::getAge));
        System.out.println(Arrays.toString(students));

        System.out.println("-------->测试性能<----------");
        int[] dataSize ={10000, 10_0000};
        for (int i = 0; i < dataSize.length; i++) {
            Integer[] data = ArrayGenerator.generatorRandomArray(dataSize[i], dataSize[i]);
            SortHelper.sortTest(SortType.SELECTION_SORT, data);
        }

    }
}
