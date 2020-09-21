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
        bubbleSort(array);
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        quickSort(array);
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int array[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);

            quickSort(array, begin, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }
    }

    public static int partition(int array[], int begin, int end) {
        int pivot = array[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (array[j] < pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = temp;

        return i + 1;
    }

    public static void mergeSort(int[] array, int n) {
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }

        for (int i = mid; i < n; i++) {
            right[i - mid] = array[i];
        }

        mergeSort(left, mid);
        mergeSort(right, n - mid);

        merge(array, left, right, mid, n - mid);
    }

    public static void merge(int[] array, int[] left, int[] right, int leftLen, int rightLen) {
        int i = 0, j = 0, k = 0;
        while (i < leftLen && j < rightLen) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < leftLen) {
            array[k++] = left[i++];
        }

        while (j < rightLen) {
            array[k++] = right[j++];
        }
    }

    public static void insertSortByIteration(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }

    public static void insertSortByRecursion(int[] array, int i) {
        if (i <= 1) {
            return;
        }
        insertSortByRecursion(array, i - 1);

        int key = array[i - 1];
        int j = i - 2;

        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j];
            j = j - 1;
        }

        array[j + 1] = key;
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minElementIndex] > array[j]) {
                    minElementIndex = j;
                }
            }

            if (minElementIndex != i) {
                int temp = array[i];
                array[i] = array[minElementIndex];
                array[minElementIndex] = temp;
            }
        }
    }
}
