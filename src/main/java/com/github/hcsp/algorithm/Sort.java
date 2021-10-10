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
        for (int i = 0; i < array.length - 1; i++) {
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
    // 按照从小到大排序
    public static void sort2(int[] array) {
        quickSort(array, 0, array.length-1);
    }

    private static void quickSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int index = partition(array, leftIndex, rightIndex);
            quickSort(array, leftIndex, index-1);
            quickSort(array, index+1, rightIndex);
        }
    }

    private static int partition(int[] array, int leftIndex, int rightIndex) {
        int pivot = array[rightIndex];
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[leftIndex] < pivot) {
                leftIndex++;
            }
            if (leftIndex < rightIndex) {
                swap(array, leftIndex, rightIndex);
                rightIndex--;
            }
            while (leftIndex < rightIndex && array[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex < rightIndex) {
                swap(array, leftIndex, rightIndex);
                leftIndex++;
            }
        }
        return leftIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
