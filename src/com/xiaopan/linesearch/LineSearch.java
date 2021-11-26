package com.xiaopan.linesearch;

import com.xiaopan.linesearch.bean.Student;

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

    public static void main(String[] args) {
        // 性能测试, 数据规模, 算法, 对数器, 运行次数
        int[] dataSize = {10_0000, 1000_0000};
        for(int size : dataSize) {
            Integer[] arr = ArrayGenerator.generatorOrderedArray(size);
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) {
                LineSearch.lineSearch(arr, size);
            }
            long endTime = System.currentTimeMillis();
            long interval = endTime - startTime;
            System.out.println("线性查找, 数据规模: " + size + " 运行: 100次 耗时: " + interval + " ms" );
        }

    }

}


