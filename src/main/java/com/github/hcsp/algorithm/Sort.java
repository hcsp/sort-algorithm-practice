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
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[i]) {
                    int a = array[i];
                    array[i] = array[j];
                    array[j] = a;
                }
            }
        }
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {

        int pivot = 0;

        if (left < right) {

            pivot = partition(arr, left, right);

            quickSort(arr, left, pivot - 1);

            quickSort(arr, pivot + 1, right);

        }

    }

    private static int partition(int[] array, int left, int right) {
        int key = array[left];
        while (left < right) {
            while (left < right && array[right] >= key) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= key) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = key;
        return left;
    }
}
