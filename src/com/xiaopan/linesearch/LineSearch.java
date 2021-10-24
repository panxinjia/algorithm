package com.xiaopan.linesearch;

public class LineSearch {

    private LineSearch() {
        // nothing to do
    }

    public static void main(String[] args) {
        int[] data = {2, 11, 5, 52, 10, 100, 30};
        int target = 3000;
        int index = LineSearch.lineSearch(data, target);
        if (index != -1)
            System.out.println("index: " + index + ", value:" + data[index]);
    }

    /**
     * 线性查找
     * @param arr 数组元素
     * @param target 目标
     * @return 索引值
     */
    private static int lineSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private static <E extends Comparable<E>> int lineSearch(E[] data, E target) {


        return -1;
    }

}


