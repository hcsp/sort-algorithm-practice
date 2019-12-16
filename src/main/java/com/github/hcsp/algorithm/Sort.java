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
        quickSort(array, 0, array.length - 1, false);
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void quickSort(int[] array, int start, int end, boolean asc) {
        if (end <= start) {
            return;
        }
        int pivot = array[start];
        int low = start, high = end;

        while (low < high) {
            while (low < high && ((pivot <= array[high] && asc) || (pivot >= array[high] && !asc))) {
                high--;
            }
            swap(array, low, high);

            while (low < high && ((array[low] <= pivot && asc) || (array[low] >= pivot && !asc))) {
                low++;
            }
            swap(array, low, high);
        }

        quickSort(array, start, low, asc);
        quickSort(array, low + 1, end, asc);

    }
}
