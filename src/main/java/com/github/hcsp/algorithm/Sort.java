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

    // 排序算法1 冒泡排序
    // 按照从小到大排序
    public static void sort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // 2.控制每轮比较几次
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    switchArray(array, j, j + 1);
                }
            }
        }
    }

    // 排序算法2 选择排序
    // 按照从小到大排序
    public static void sort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // 2.控制每轮比较几次
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    switchArray(array, i, j);
                }
            }
        }
    }

    public static void switchArray(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
