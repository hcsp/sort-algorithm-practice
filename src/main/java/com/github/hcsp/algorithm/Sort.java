package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array3 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array4 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        sort1(array1);
        sort2(array2);
        sort3(array3);
        sort4(array4);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));
    }

    // 冒泡排序
    // 按照从小到大排序
    public static void sort1(int[] array) {
        boolean sorted;
        for (int i = 0; i < array.length - 1; i++) {
            sorted = false;
            for (int j = 0; j + 1 < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    sorted = true;
                }
            }

            if (!sorted) {
                break;
            }
        }
    }

    // 快速排序
    // 按照从小到大排序
    public static void sort2(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // 归并排序
    // 按照从小到大排序
    public static void sort3(int[] array) {
        int n = array.length;
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

        sort3(left);
        sort3(right);
        merge(array, left, right);
    }

    // 堆排序
    // 按照从小到大排序
    public static void sort4(int[] array) {
        int len = array.length - 1;
        int beginIndex = (array.length >> 1) - 1;
        for (int i = beginIndex; i >= 0; i--) {
            heapify(array, i, len);
        }

        for (int i = len; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, 0, i - 1);
        }
    }

    private static void heapify(int[] array, int index, int len) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max = left;
        if (left > len) {
            return;
        }
        if ((right <= len) && (array[right] > array[left])) {
            max = right;
        }

        if (array[max] > array[index]) {
            swap(array, max, index);
            heapify(array, max, len);
        }
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int nL = left.length;
        int nR = right.length;
        int i = 0, j = 0, k = 0;

        while (i < nL && j < nR) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < nL) {
            array[k] = left[i];
            i++;
            k++;
        }

        while (j < nR) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pIndex = partition(array, start, end);
            quickSort(array, start, pIndex - 1);
            quickSort(array, pIndex + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {
                swap(array, i, pIndex);
                pIndex++;
            }
        }
        swap(array, pIndex, end);
        return pIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
