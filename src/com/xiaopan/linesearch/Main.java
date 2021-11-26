package com.xiaopan.linesearch;

import com.xiaopan.linesearch.bean.Student;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    private static final Random RANDOM = new Random();


    public static void main(String[] args) {
        // bar();
//        foo();
//        Integer[] arr = IntStream.rangeClosed(1, 100)
//                .boxed()
//                .toArray(Integer[]::new);
//
//        int index1 = find(arr, 100);
//        System.out.println("index1 = " + index1);
//
//        int index2 = find(arr, 200);
//        System.out.println("index2 = " + index2);

        Student[] students = {
                new Student("tom", 20),
                new Student("jerry", 100),
                new Student("bob", 30)
        };

        //int index = LineSearch.lineSearch(students, new Student("tom",200));
        int index = LineSearch.lineSearch(students, new Student());
        System.out.println(index);


    }

    /**
     * 线性查找法: 统一返回入口, 明确输入和输出值
     *
     * @param arr    查找数据集
     * @param target 目标元素
     * @param <E>    数据集和目标元素类型
     * @return 目标元素在数据集中的索引位置, -1 表示不存在
     */
    public static <E> int find(E[] arr, E target) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static void foo() {
        // 线性查找性能测试
        int[] dataSize = {100_0000, 1000_0000};
        for (int n : dataSize) {
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
