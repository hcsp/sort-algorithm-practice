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
        boolean isSorted;
        for (int i = array.length - 1; i > 0; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (array[j + 1] <= array[j]) {
                    swap(array, j + 1, j);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
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
        quickSort(array, 0, array.length - 1);
    }

    private static int getIndex(int[] array, int low, int high) {
        int baseValue = array[low];

        while (low < high) {
            while (array[high] >= baseValue && low < high) {
                high--;
            }
            array[low] = array[high];

            while (array[low] <= baseValue && low < high) {
                low++;
            }
            array[high] = array[low];
        }

        array[low] = baseValue;
        return low;
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int index = getIndex(array, low, high);
            quickSort(array, low, index - 1);
            quickSort(array, index + 1, high);
        }

    }
}
