package com.xiaopan.sort.tools;

/**
 * 排序算法类型
 */
public enum SortType {
    SELECTION_SORT("选择排序"),
    INSERTION_SORT("插入排序"),
    BUBBLE_SORT("冒牌排序"),
    MERGER_SORT("归并排序");


    private final String sortName;

    private SortType(String sortName) {
        this.sortName = sortName;
    }

    public String getSortName() {
        return sortName;
    }
}
