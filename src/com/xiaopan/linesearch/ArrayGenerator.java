package com.xiaopan.linesearch;

public class ArrayGenerator {

    private ArrayGenerator() {}

    public static Integer[] generatorOrderedArray(int n) {
        Integer[] data = new Integer[n];
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }
        return data;
    }
}
