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
    //冒泡排序
    public static void sort1(int[] array) {
        int j = array.length;
        for (int i = 0; i < j; i++) {
            for (int k = 0; k < j - 1; k++) {
                if (array[k] > array[k + 1]) {
                    int temp = array[k];
                    array[k] = array[k + 1];
                    array[k + 1] = temp;
                }
            }
        }
    }

    // 排序算法2
    // 按照从小到大排序
    //选择排序
    public static void sort2(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }


    //排序算法3
    //快速排序-从小到大
    public static void quickSort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int pivot = array[left];
        int i = left + 1;
        int j = right;
        while (i < j) {
            while (pivot <= array[j] && i < j) {
                j--;
            }
            while (pivot >= array[i] && i < j) {
                i++;
            }
            if (i < j) {
                int temp1 = array[i];
                int temp2 = array[j];
                array[i] = temp2;
                array[j] = temp1;
            }

        }
        array[left] = array[i];
        array[i] = pivot;

        quickSort(array, left, j - 1);
        quickSort(array, j + 1, right);

    }
}



