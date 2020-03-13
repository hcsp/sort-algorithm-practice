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
        sort3(array3);
        sort4(array4);
        array5 = sort5(array5);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));
        System.out.println(Arrays.toString(array5));
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    // 排序算法1
    // 插入排序
    public static void sort1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int item = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (item > array[j]) {
                    array[j + 1] = item;
                    break;
                } else {
                    array[j + 1] = array[j];
                    array[j] = item;
                }
            }
        }
    }

    // 排序算法2
    // 并归排序
    public static void mergeSort(int[] array, int l, int r) {
        if (r - l < 2) {
            return;
        }
        int m = (l + r) % 2 == 0 ? (l + r) / 2 : ((l + r) / 2 + 1);
        mergeSort(array, l, m);
        mergeSort(array, m, r);
        merge(array, l, m, r);
    }

    public static void merge(int[] array, int p, int t, int q) {
        int[] left = new int[t - p + 1];
        int[] right = new int[q - t + 1];
        for (int i = p; i < t; i++) {
            left[i - p] = array[i];
        }
        for (int j = t; j < q; j++) {
            right[j - t] = array[j];
        }
        left[t - p] = Integer.MAX_VALUE;
        right[q - t] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for (int k = p; k < q; k++) {
            array[k] = left[i] > right[j] ? right[j++] : left[i++];
        }
    }

    public static void sort2(int[] array) {
        mergeSort(array, 0, array.length);
    }

    // 排序算法3
    // 快速排序
    public static int partition(int[] array, int p, int q) {
        int pivot = array[q - 1];
        int i = p;
        int j = q - 1;
        while (i != j) {
            if (array[i] < pivot) {
                i++;
            } else {
                swap(array, i, --j);
            }
        }
        swap(array, j, q - 1);
        return j;
    }

    public static void quickSort(int[] array, int l, int r) {
        if (r - l <= 1) {
            return;
        }
        int m = partition(array, l, r);
        quickSort(array, l, m);
        quickSort(array, m + 1, r);
    }

    public static void sort3(int[] array) {
        quickSort(array, 0, array.length);
    }

    // 排序算法4
    // 选择排序
    public static void sort4(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
    }

    // 排序算法5
    // 计数排序
    public static int[] sort5(int[] array) {
        // 用于回写的数组
        int[] returnArray = array.clone();
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int[] countArray = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]] += 1;
        }
        for (int j = 1; j < countArray.length; j++) {
            countArray[j] = countArray[j - 1] + countArray[j];
        }
        for (int k = 0; k < array.length; k++) {
            int count = countArray[array[k]];
            returnArray[count - 1] = array[k];
            countArray[array[k]] -= 1;
        }
        return returnArray;
    }
}
