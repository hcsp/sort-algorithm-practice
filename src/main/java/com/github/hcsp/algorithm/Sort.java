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
        for (int i = 0; i < array.length - 1; i++) {
            int minPos = i;

            for (int j = i + 1; j < array.length; j++) {
                minPos = array[j] < array[minPos] ? j : minPos;
            }
            swp(array, i, minPos);

        }
    }
    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < array.length; j++) {
                minPos = array[j] < array[minPos] ? j : minPos;
            }
            int maxPos = i;
            for (int k = i + 1; k < array.length; k++) {
                maxPos = array[i] > array[maxPos] ? k : maxPos;
            }
            swp(array, i, minPos);
        }
    }
    static void swp(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
