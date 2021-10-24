package com.xiaopan.linesearch;

import com.xiaopan.linesearch.bean.Student;

public class Main {


    public static void main(String[] args) {
        // bar();
        foo();
    }

    private static void foo() {
        // 线性查找性能测试
        int[] dataSize = {100_0000, 1000_0000};
        for(int n: dataSize) {
            Integer[] data = ArrayGenerator.generatorOrderedArray(n);
            long start = System.nanoTime();
            // 每个数量级运行100次
            for (int i = 0; i < 100; i++) {
                LineSearch.lineSearch(data, n);
            }
            long end = System.nanoTime();
            double time = (end - start) / 1000_000_000.0;// 时间单位 秒
            System.out.println("n = " + n + " runs = " + 100 + " times = " + time);
        }
    }

    private static void bar() {
        int[] data = {2, 11, 5, 52, 10, 100, 30};
        int target = 100;
        // int index = LineSearch.lineSearch(data, target);
        int index = LineSearch.<Integer>lineSearch(data, target);
        if (index != -1)
            System.out.println("index: " + index + ", value:" + data[index]);

        Student[] ss = {
                new Student("tom", 20), new Student("jerry", 18),
                new Student("bob", 30)
        };

        int idx = LineSearch.<Student>lineSearch(ss, new Student("bob", 30));
        System.out.println("idx = " + idx);
    }


}
