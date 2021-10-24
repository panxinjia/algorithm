package com.xiaopan.linesearch;

public class LineSearch {

    private LineSearch() {
        // nothing to do
    }

    /**
     * 线性查找
     * @param arr 数组元素
     * @param target 目标
     * @return 索引值
     */
    public static int lineSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static <E extends Comparable<E>> int lineSearch(E[] data, E target) {


        return -1;
    }

}


