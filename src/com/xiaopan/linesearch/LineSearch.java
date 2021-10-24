package com.xiaopan.linesearch;

import com.xiaopan.linesearch.bean.Student;

public class LineSearch {

    private LineSearch() {
        // nothing to do
    }

    /**
     * 线性查找
     * @param data 数组
     * @param target 目标
     * @return 索引值
     */
    public static int lineSearch(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 泛型线性查找支持所有引用数据类型
     * @param data 数组
     * @param target 目标
     * @return 索引值
     */
    public static <E> int lineSearch(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }


}


