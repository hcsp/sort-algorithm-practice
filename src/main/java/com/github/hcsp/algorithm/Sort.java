package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[] {4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[] {4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        sort1(array1);
        sort2(array2);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    // 排序算法1 冒泡
    // 按照从小到大排序
    public static void sort1(int[] array) {
        int length = array.length;
        for (int len = length - 1; len > 0; len--) {
            for (int i = 0; i < length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    // 交换
                    swapValue(array, i, (i + 1));
                }
            }
        }

    }

    // 排序算法2 快排
    // 按照从小到大排序
    public static void sort2(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // 基准值
        int small = (low - 1);
        for (int i = low; i <= high - 1; i++) {
            if (array[i] <= pivot) {
                small++;
                swapValue(array, small, i);
            }
        }
        small++;
        swapValue(array, small, high);

        return small;
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static void swapValue(int[] array, int small, int i) {
        int temp = array[small];
        array[small] = array[i];
        array[i] = temp;
    }

}
