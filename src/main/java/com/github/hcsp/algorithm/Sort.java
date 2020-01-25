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
        for (int orderingIndex = 1; orderingIndex < array.length; orderingIndex++) {
            int end = orderingIndex - 1;
            int orderingInt = array[orderingIndex];
            while (end >= 0 && orderingInt < array[end]) {
                array[end + 1] = array[end];
                end = end - 1;
            }
            array[end + 1] = orderingInt;
        }
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        int[] mergeSortedArray = new int[array.length];
        mergeSort(array, mergeSortedArray, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] mergeSortedArray, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = ((end - start) >> 1) + start;
        int start1 = start, end1 = middle;
        int start2 = middle, end2 = end;
        mergeSort(array, mergeSortedArray, start1, end1);
        mergeSort(array, mergeSortedArray, start2, end2);
        int key = start;
        while (start1 <= end1 && start2 <= end2) {
            mergeSortedArray[key++] = array[start1] < array[start2] ? array[start1++] : array[start2++];
        }
        while (start1 <= end1) {
            mergeSortedArray[key++] = array[start1++];
        }
        while (start2 <= end2) {
            mergeSortedArray[key++] = array[start2++];
        }
        if (end + 1 - key >= 0) {
            System.arraycopy(mergeSortedArray, key, array, key, end + 1 - key);
        }
    }
}
