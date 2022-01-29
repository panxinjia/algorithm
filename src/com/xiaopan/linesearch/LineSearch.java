package com.xiaopan.linesearch;

import com.xiaopan.linesearch.bean.Student;

import javax.sound.sampled.Line;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 线性查找法:
 *  工具性方法, 应用单例模式
 */
public class LineSearch {

    private LineSearch() {

    }

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

    @Deprecated
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

    @Deprecated
    public static <E extends Comparable> int search(E[] data, E target) {
        if (data == null)
            return -1;

        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target))
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {



//        Student s1 = new Student("tom",20);
//        Student s2 = new Student("jerry", 30);
//        Student s3 = new Student("bob", 19);
//
//        Student[] students = new Student[] {s1,s2,s3};
//
//        int index = LineSearch.<Student>lineSearch(students, new Student("bob", 19));
//        int index2 = LineSearch.<Student>lineSearch(students, new Student("kite", 10));
//
//        System.out.println("index = " + index);
//        System.out.println("index2 = " + index2);

//        int[] data = {1,2,3,4,5,6,8};
//
//        int idx1 = search(data, 1);
//        int idx2 = search(data,8);
//        int idx3 = search(data, 10);
//
//        System.out.println("idx1 = " + idx1);
//        System.out.println("idx2 = " + idx2);
//        System.out.println("idx3 = " + idx3);
//
//
//        // 泛型通用线性查找算法
//        Integer[] arr = IntStream.rangeClosed(1, 100)
//                .boxed().toArray(Integer[]::new);
//        int idx4 = search(arr, 10);
//        System.out.println("idx4 = " + idx4);


//        线性查找性能测试, O(n) 时间复杂度和数据规模是线性关系
        int[] dataSize = {10_0000, 1000_0000};
        for(int size : dataSize) {
            Integer[] arr = ArrayGenerator.generatorOrderedArray(size);
            // 查找100次开始时间
            long startTime = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                LineSearch.lineSearch(arr, size);
            }
            // 查找100次结束时间
            long endTime = System.nanoTime();
            long interval = endTime - startTime;
            System.out.println("线性查找, 数据规模: " + size + " 运行: 100次 耗时: " + (interval / 1000_000_000.0) + " ms" );
        }

    }

}


