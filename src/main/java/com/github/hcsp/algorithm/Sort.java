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

    // 排序算法1：冒泡排序
    // 按照从小到大排序
    public static void sort1(int[] array) {
        int length = array.length;
        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] x, int a, int b) {
        int t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    // 排序算法2：快速排序
    // 按照从小到大排序
    public static void sort2(int[] array) {
        sort2(array, 0, array.length - 1);
    }

    /**
     * pivot：三数取中间值
     */
    private static void dealWithPivot(int[] array, int left, int right) {
        int mid = (left + right) / 2;

        if (array[left] > array[mid]) {
            swap(array, left, mid);
        }
        if (array[left] > array[right]) {
            swap(array, left, right);
        }
        if (array[mid] > array[right]) {
            swap(array, mid, right);
        }

        swap(array, left, mid);

    }

    public static void sort2(int[] array, int left, int right) {
        if (left < right) {
            dealWithPivot(array, left, right);
            int partitionIndex = partition(array, left, right);
            sort2(array, left, partitionIndex - 1);
            sort2(array, partitionIndex + 1, right);
        }
    }

    public static int partition(int[] array, int left, int right) {
        int pivot = left;
        int index = left + 1;

        for (int i = index; i <= right; i++) {
            if (array[i] < array[pivot]) {
                swap(array, index, i);
                index++;
            }
        }

        swap(array, pivot, index - 1);

        return index - 1;
    }

}
