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
        //冒泡排序
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        //快速排序
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int temp;
        int l = left;
        int r = right;
        int pivot = array[left];
        while (l != r) {
            while (array[r] >= pivot && l < r) {
                r--;
            }
            while (array[l] <= pivot && l < r) {
                l++;
            }
            if (l < r) {
                temp = array[l];
                array[l] = array[r];
                array[r] = temp;
            }
        }
        temp = array[l];
        array[l] = array[left];
        array[left] = temp;

        quickSort(array, left, l - 1);
        quickSort(array, l + 1, right);
    }
}
