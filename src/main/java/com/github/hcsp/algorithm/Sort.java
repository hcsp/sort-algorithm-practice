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
        shellSort(array);
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void shellSort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < array.length - gap; i++) {
                int j = i;
                //相邻比较,成功再和之前比较
                while (j >= 0 && array[j + gap] < array[j]) {
                    swap(array, j + gap, j);
                    j = j - gap;
                }
            }
        }
    }

    private static void quickSort(int[] array, int start, int end) {
        Pivot pivot = dealPivot(array, start, end);
        if ((end - start) <= 2) {
            return;
        }
        int s = start;
        int e = end;
        while (s < e) {
            while (s < e && array[s] < pivot.value) {
                s++;
            }
            while (s < e && array[e] > pivot.value) {
                e--;
            }
            if (s < e && array[s] == array[e]) {
                s++;
            } else {
                swap(array, s, e);
            }
        }

        quickSort(array, start, e - 1);
        quickSort(array, s + 1, end);

    }

    private static Pivot dealPivot(int[] array, int start, int end) {
        int mid = (start + end) / 2;
        if (array[mid] > array[end]) {
            swap(array, mid, end);
        }
        if (array[start] > array[end]) {
            swap(array, start, end);
        }
        if (array[start] > array[mid]) {
            swap(array, start, mid);
        }
        return new Pivot(mid, array[mid]);
    }

    private static class Pivot {
        int index;
        int value;

        private Pivot(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int cache = array[i];
        array[i] = array[j];
        array[j] = cache;
    }
}
