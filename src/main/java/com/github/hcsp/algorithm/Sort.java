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

    // 排序算法1
    // 按照从小到大排序

    public static void sort1(int[] array) {
        quickSort(array, 0, array.length-1);
    }
    public static void quickSort(int[] array, int start, int end){
        if (start >= end || array == null || array.length <= 1){
            return;
        }
        int i = start;
        int j = end;
        int base = array[(start + end) / 2];
        while (i <= j) {
            while (array[i] < base) {
                i++;
            }
            while (array[j] > base) {
                j--;
            }
            if (i < j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        quickSort(array, start, j);
        quickSort(array, i, end);
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        //Bubble sort
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if (array[j] > array [j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
