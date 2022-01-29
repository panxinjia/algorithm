package com.xiaopan.linesearch;

import com.xiaopan.linesearch.bean.Student;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 线性查找法:
 *  工具性方法, 应用单例模式
 */
public class LineSearch {

    private LineSearch() {
        // nothing to do
    }

    /**
     * 线性查找
     * @param data 数组
     * @param target 目标
     * @return 索引值
     */
    public static int lineSearch(int[] data, int target) {
        if (data == null)
            return -1;

        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 泛型线性查找支持所有引用数据类型
     * @param data 数组
     * @param target 目标
     * @return 索引值
     */
    public static <E> int lineSearch(E[] data, E target) {
        if (data == null)
            return -1;

        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static int search(int[] data, int target) {
        if (data == null)
            return -1;

        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static <E extends Comparable> int search(E[] data, E target) {
        // 临界值
        if (data == null)
            return -1;

        // 清晰, 明确, 可执行的指令集合, 查找元素位置
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target))
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,8};

        int idx1 = search(data, 1);
        int idx2 = search(data,8);
        int idx3 = search(data, 10);

        System.out.println("idx1 = " + idx1);
        System.out.println("idx2 = " + idx2);
        System.out.println("idx3 = " + idx3);


        // 泛型通用线性查找算法
        Integer[] arr = IntStream.rangeClosed(1, 100)
                .boxed().toArray(Integer[]::new);
        int idx4 = search(arr, 10);
        System.out.println("idx4 = " + idx4);


        // 性能测试, 数据规模, 算法, 对数器, 运行次数
//        int[] dataSize = {10_0000, 1000_0000};
//        for(int size : dataSize) {
//            Integer[] arr = ArrayGenerator.generatorOrderedArray(size);
//            long startTime = System.currentTimeMillis();
//            for (int i = 0; i < 100; i++) {
//                LineSearch.lineSearch(arr, size);
//            }
//            long endTime = System.currentTimeMillis();
//            long interval = endTime - startTime;
//            System.out.println("线性查找, 数据规模: " + size + " 运行: 100次 耗时: " + interval + " ms" );
//        }

    }

}


