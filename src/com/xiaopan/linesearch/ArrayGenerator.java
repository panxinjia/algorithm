package com.xiaopan.linesearch;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ArrayGenerator {

    /**
     * 随机数生成器
     */
    private static final Random RANDOM = new Random();

    private ArrayGenerator() {}

    /**
     * 生成有序数组
     * @param n 元素个数
     * @return 数组
     */
    public static Integer[] generatorOrderedArray(int n) {
        return IntStream.rangeClosed(1, n)
                .boxed()
                .toArray(Integer[]::new);
    }


    /**
     * 生成随机数组
     * @param n 元素个数
     * @return 数组
     */
    public static Integer[] generatorArray(int n) {
        return RANDOM.ints(n, 1, n)
                .boxed()
                .toArray(Integer[]::new);
    }

    /**
     * 生成随机数组
     * @param n 元素个数
     * @param leftBound 左边界
     * @param rightBound 右边界
     * @return 数组
     */
    public static Integer[] generatorArray(int n, int leftBound, int rightBound) {
        return RANDOM.ints(n, leftBound, rightBound)
                .boxed()
                .toArray(Integer[]::new);
    }


}
