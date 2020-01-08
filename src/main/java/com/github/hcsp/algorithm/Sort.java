package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        sort1(array1);
        sort2(array2);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    // 排序算法1
    // 按照从小到大排序
    public static void sort1(int[] array) {
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
    }

    // 排序算法N
    // 按照从小到大排序
    // 如果多于 2 个，可以按照如下格式命名方法，其中 N 为正整数
    // public static void sortN(int[] array) {}
}
