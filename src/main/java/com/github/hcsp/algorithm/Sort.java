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

    // 冒泡排序
    // 按照从小到大排序
    public static void sort1(int[] array) {
        bubbleSort(array);
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static int partition(int[] array, int left, int right, int pivotIndex) {
        int pivotValue = array[pivotIndex];
        swapValueInArray(array, pivotIndex, right);
        int nextPivotIndex = left;
        for (int i = left; i < right; i++) {
            if (array[i] <= pivotValue) {
                swapValueInArray(array, i, nextPivotIndex);
                nextPivotIndex += 1;
            }
        }
        swapValueInArray(array, right, nextPivotIndex);
        return nextPivotIndex;
    }

    public static void quickSort(int[] array, int left, int right) {
        if (right > left) {
            int pivotNewIndex = partition(array, left, right, left);
            quickSort(array, left, pivotNewIndex - 1);
            quickSort(array, pivotNewIndex + 1, right);
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swapValueInArray(array, j, i);
                }
            }
        }
    }

    public static void swapValueInArray(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
