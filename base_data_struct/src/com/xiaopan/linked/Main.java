package com.xiaopan.linked;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        System.out.println(list);
        list.addFirst(10);
        list.addFirst(100);
        System.out.println(list);
        list.add(1, 9);
        System.out.println(list);

//        IntStream.rangeClosed(0, 99)
//                .forEach(list::addLast);

//        System.out.println(list);
        System.out.println("first:" + list.getFirst());
        System.out.println("last:" + list.getLast());


        Integer val = list.set(1, 8);
        System.out.println("set 1:" + val);
        System.out.println(list);

//        System.out.println("removeFist: " + list.removeFirst());
//        System.out.println(list);
//        System.out.println("removeLast: " + list.removeLast());
//        System.out.println(list);
        System.out.println("remove: " + list.remove(0));
        System.out.println(list);
        LinkedList<Integer> link = new LinkedList<>();

    }
}
