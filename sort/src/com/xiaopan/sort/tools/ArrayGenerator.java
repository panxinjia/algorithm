package com.xiaopan.sort.tools;

import java.util.Random;

public class ArrayGenerator {

    private static final Random RANDOM = new Random();
    private ArrayGenerator() {}

    public static Integer[] generatorOrderedArray(int n) {
        Integer[] data = new Integer[n];
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }
        return data;
    }

    /**
     * 生成指定边界的随机数组
     * @param n 数组长度
     * @param bound 边界
     * @return 数组
     */
    public static Integer[] generatorRandomArray(int n, int bound) {
        Integer[] data = new Integer[n];
        for (int i = 0; i < n; i++) {
            data[i] = RANDOM.nextInt(bound);
        }
        return data;
    }
}
