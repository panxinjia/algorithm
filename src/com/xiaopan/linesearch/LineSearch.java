package com.xiaopan.linesearch;

public class LineSearch {

    private LineSearch() {
        // nothing to do
    }

<<<<<<< HEAD
=======
    public static void main(String[] args) {
        int[] data = {2, 11, 5, 52, 10, 100, 30};
        int target = 3000;
        int index = LineSearch.lineSearch(data, target);
        if (index != -1)
            System.out.println("index: " + index + ", value:" + data[index]);
    }

>>>>>>> d956a03068740678acab1864ed91fd72e003b8ce
    /**
     * 线性查找
     * @param arr 数组元素
     * @param target 目标
     * @return 索引值
     */
<<<<<<< HEAD
    public static int lineSearch(int[] arr, int target) {
=======
    private static int lineSearch(int[] arr, int target) {
>>>>>>> d956a03068740678acab1864ed91fd72e003b8ce
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

<<<<<<< HEAD
    public static <E extends Comparable<E>> int lineSearch(E[] data, E target) {
=======
    private static <E extends Comparable<E>> int lineSearch(E[] data, E target) {
>>>>>>> d956a03068740678acab1864ed91fd72e003b8ce


        return -1;
    }

}


