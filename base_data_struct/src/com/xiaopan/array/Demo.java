package com.xiaopan.array;

import com.xiaopan.Student;

import java.util.Objects;

/**
 * @author xiaopantx
 * @version 1.0
 * @description TODO
 */
public class Demo {
    public static void main(String[] args) {

//        System.out.println(Objects.equals(null,10));

        DynamicArray<Student> studentDynamicArray = new DynamicArray<>();

//        动态数组, 保存自定义元素
        studentDynamicArray.addLast(new Student("tom", 20));
        studentDynamicArray.addLast(new Student("jerry",10));
        studentDynamicArray.add(new Student("bob",10), 1);
        System.out.println(studentDynamicArray);
    }
}
