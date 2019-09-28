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
        int low = 0;
        int high = array.length - 1;
        int[] tmpArray = new int[array.length];
        mergeSort(array, tmpArray, low, high);
    }

    private static void mergeSort(int[] array, int[] tmpArray, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) >> 1;
        mergeSort(array, tmpArray, low, mid);
        mergeSort(array, tmpArray, mid + 1, high);
        merge(array, tmpArray, low, mid, high);
    }

    private static void merge(int[] array, int[] tmpArray, int low, int mid, int high) {
        int indexOfLeft = low;
        int indexOfRight = mid + 1;

        for (int i = low; i <= high; i++) {
            if (indexOfLeft > mid) {
                tmpArray[i] = array[indexOfRight++];
            } else if (indexOfRight > high) {
                tmpArray[i] = array[indexOfLeft++];
            } else if (array[indexOfLeft] < array[indexOfRight]) {
                tmpArray[i] = array[indexOfLeft++];
            } else {
                tmpArray[i] = array[indexOfRight++];
            }
        }

        for (int j = low; j <= high; j++) {
            array[j] = tmpArray[j];
        }

    }


    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                swap(array, j, j - 1);
                j--;
            }

        }
    }

}
