package com.xiaopan.array;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * @author xiaopantx
 * @version 1.0
 * @description TODO
 */
public class Main {

    public static void main(String[] args) {
        DynamicArray<Integer> list = new DynamicArray(20);
        for (int i = 0; i < 10; i++) {
            list.add(i + 1, i);
        }
        System.out.println(list);
        list.addFirst(999);
        System.out.println(list);

        list.addLast(-100);
        System.out.println(list);
        list.addFirst(-1);
        System.out.println(list);

        // list.set(89, -100);
        //list.set(89, 300);
        list.set(89, 2);
        System.out.println(list);

        System.out.println(list.find(10));
        System.out.println(list);

        System.out.println(list.remove(10));
        System.out.println(list);

        list.addLast(100);
        list.add(100, list.size());
        System.out.println(list);

        int[] idxs = list.findAll(100);
        System.out.println("findAll: " + Arrays.toString(idxs));

        Object[] ints = list.removeAll(100);
        System.out.println(Arrays.toString(ints));
        System.out.println(list);

        System.out.println("<-------------------------------->");

        for(Object i: ints) {
            System.out.println(i + ", " + i.getClass());
        }

        System.out.println("<-------------------------------->");

        IntStream.rangeClosed(1,20)
                .forEach(val -> {
                    list.addLast(val);
                    System.out.println(list);
                });

        System.out.println("<-------------------------------->");




    }
}
