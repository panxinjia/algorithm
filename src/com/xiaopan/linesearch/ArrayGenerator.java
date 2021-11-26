package com.xiaopan.linesearch;

import java.util.Random;
import java.util.stream.IntStream;

public class ArrayGenerator {

    /**
     * 随机数生成器
     */
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
     * 生成有序数组
     * @param n 数组边界
     * @return 数组
     */
    public static Integer[] generatorArray(int n) {
        return IntStream.rangeClosed(1,n)
                .boxed()
                .toArray(Integer[]::new);
    }


}
