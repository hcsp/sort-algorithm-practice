package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        sort1(array1);
        sort2(array2);

//        int[] test = new int[4];
//        System.arraycopy(array1, 3, test, 0, 4);
//
//        System.out.println(Arrays.toString(test));

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int[] left = new int[mid - l + 1];
        int[] right = new int[r - mid];

        System.arraycopy(arr, l, left, 0, left.length);
        System.arraycopy(arr, mid + 1, right, 0, right.length);

        // merge two sorted half, left and right
        int leftIndex = 0, rightIndex = 0;

        for (int i = l; i <= r; i++) {
            int leftNum = leftIndex < left.length ? left[leftIndex] : Integer.MAX_VALUE;
            int rightNum = rightIndex < right.length ? right[rightIndex] : Integer.MAX_VALUE;

            if (leftNum <= rightNum) {
                arr[i] = leftNum;
                leftIndex++;
            } else {
                arr[i] = rightNum;
                rightIndex++;
            }
        }
    }


    // 排序算法1
    // 按照从小到大排序
    public static void sort1(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }

    //
    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int boundary = l;
        for (int i = l; i < r; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, boundary++);
            }
        }
        swap(arr, boundary, r);
        return boundary;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        quickSort(array, 0, array.length - 1);
    }
}
