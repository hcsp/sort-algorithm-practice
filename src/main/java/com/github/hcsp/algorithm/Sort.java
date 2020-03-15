package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array3 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array4 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array5 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};

        sort1(array1);
        sort2(array2);
        insertSort(array4);
        selectSort(array5);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(mergeSort(array3)));
        System.out.println(Arrays.toString(array4));
        System.out.println(Arrays.toString(array5));
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 排序算法1
    // 按照从小到大排序
    // 冒泡排序
    public static void sort1(int[] array) {
        int arrayLength = array.length - 1;
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    // 排序算法2
    // 按照从小到大排序
    // 快速排序
    public static void sort2(int[] array) {
        quickSortMethod(array, 0, array.length - 1);
    }

    private static void quickSortMethod(int[] array, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(array, left, right);
            quickSortMethod(array, left, partitionIndex - 1);
            quickSortMethod(array, partitionIndex + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (array[i] < array[left]) {
                swap(array, i, index);
                index++;
            }
        }
        swap(array, left, index - 1);
        return index - 1;
    }

    // 排序算法3
    // 按照从小到大排序
    // 归并排序
    public static int[] mergeSort(int[] array) {

        if (array.length < 2) {
            return array;
        }
        int mid = (int) Math.floor(array.length >> 1);
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        return mergeSortMethod(mergeSort(left), mergeSort(right));
    }

    public static int[] mergeSortMethod(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }

    // 排序算法4
    // 按照从小到大排序
    // 插入排序
    public static void insertSort(int[] array) {
        int arrayLength = array.length;
        for (int i = 1; i < arrayLength; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            if (j != i) {
                array[j] = temp;
            }
        }
    }

    // 排序算法5
    // 按照从小到大排序
    // 选择排序
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (i != min) {
                swap(array, i, min);
            }
        }
    }
}
