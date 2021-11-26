package com.xiaopan.sort.tools;

import java.util.Random;
import java.util.stream.IntStream;

public class ArrayGenerator {

    private static final Random RANDOM = new Random();
    private ArrayGenerator() {}

    public static Integer[] generatorOrderedArray(int n) {
        return IntStream.range(0, n)
                .boxed()
                .toArray(Integer[]::new);
    }

    /**
     * 生成指定边界的随机数组
     * @param n 数据规模
     * @param bound 边界
     * @return 数组
     */
    public static Integer[] generatorRandomArray(int n, int bound) {
        return RANDOM.ints(n, 0, bound)
                .boxed()
                .toArray(Integer[]::new);
    }
}
