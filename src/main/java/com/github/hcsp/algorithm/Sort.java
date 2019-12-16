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
        quickSort(array, 0, array.length - 1, true);
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        bubbleSort(array, 0, array.length - 1);
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 快排，支持升序和降序
    public static void quickSort(int[] array, int start, int end, boolean isAsc) {
        if (end <= start) {
            return;
        }
        int pivot = array[start];
        int low = start, high = end;

        while (low < high) {
            while (low < high && ((pivot <= array[high] && isAsc) || (pivot >= array[high] && !isAsc))) {
                high--;
            }
            swap(array, low, high);

            while (low < high && ((array[low] <= pivot && isAsc) || (array[low] >= pivot && !isAsc))) {
                low++;
            }
            swap(array, low, high);
        }

        quickSort(array, start, low, isAsc);
        quickSort(array, low + 1, end, isAsc);

    }

    // 冒泡排序
    public static void bubbleSort(int[] array, int start, int end) {
        int high = end;

        while (high > start) {
            int maxIndex = start;
            int max = array[start];
            for (int i = maxIndex + 1; i <= high; i++) {
                int currentEl = array[i];
                if (max > currentEl) {
                    swap(array, i, maxIndex);
                } else {
                    max = currentEl;
                }
                maxIndex = i;
            }
            high--;
        }
    }
}
