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
        int targetIndex = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            int max = 0;
            for (int j = 0; j <= targetIndex; j++) {
                if (array[j] > array[max]) {
                    max = j;
                }
            }
            int temp = array[targetIndex];
            array[targetIndex] = array[max];
            array[max] = temp;
            targetIndex--;
        }
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] a, int left, int right) {
        int i = left;
        int j = right;
        int mid = a[(left + right) / 2];
        while (i <= j) {
            while (Math.abs(a[i]) < Math.abs(mid)) {
                i++;
            }
            while (Math.abs(mid) < Math.abs(a[j])) {
                j--;
            }
            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if (i < right) {
            quickSort(a, i, right);
        }
        if (left < j) {
            quickSort(a, left, j);
        }
    }
}
