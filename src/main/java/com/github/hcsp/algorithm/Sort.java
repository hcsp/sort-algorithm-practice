package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[] {4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[] {4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
//        sort1(array1);
        sort2(array2);

//        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    // 排序算法1
    // 按照从小到大排序(冒泡排序)
    public static void sort1(int[] array) {

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }

        }

    }

    // 排序算法2
    // 按照从小到大排序(快速排序)
    public static void sort2(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int start, int end) {
        int i = start;
        int j = end;

        if (i >= j) {
            return;
        }

        int flag = array[i];

        while (i < j) {
            while (i < j && array[j] >= flag) {
                j--;
            }

            if (i < j) {
                int temp = array[j];
                array[j] = flag;
                array[i] = temp;
            }

            while (i < j && array[i] < flag) {
                i++;
            }

            if (i < j) {
                int temp = array[i];
                array[i] = flag;
                array[j] = temp;
            }
        }

        quickSort(array, start, i);
        quickSort(array, j+1, end);
    }
}
