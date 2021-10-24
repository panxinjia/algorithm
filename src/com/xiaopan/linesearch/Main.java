package com.xiaopan.linesearch;

import com.xiaopan.linesearch.bean.Student;

public class Main {


    public static void main(String[] args) {
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
