package com.xiaopan.linesearch;

public class Main {


    public static void main(String[] args) {
        int[] data = {2, 11, 5, 52, 10, 100, 30};
        int target = 3000;
        int index = LineSearch.lineSearch(data, target);
        if (index != -1)
            System.out.println("index: " + index + ", value:" + data[index]);
    }



}
