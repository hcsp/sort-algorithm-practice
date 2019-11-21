package com.github.hcsp.algorithm;

import java.util.Arrays;


public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array3 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array4 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array5 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array6 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        sort1(array1);
        sort2(array2);
        quickSort(array3, 0, array3.length - 1);
        insertionSort(array4);
        selectionSort(array5);
        heapSort(array6);


        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));
        System.out.println(Arrays.toString(array5));
        System.out.println(Arrays.toString(array6));
    }


    // 冒泡排序
    // 按照从小到大排序
    public static void sort1(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    // 归并排序
    private static void sort2(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        mergeSortRecursive(arr, result, 0, len - 1);
    }

    private static void mergeSortRecursive(int[] arr, int[] result, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) >> 1;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        mergeSortRecursive(arr, result, start1, end1);
        mergeSortRecursive(arr, result, start2, end2);

        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1) {
            result[k++] = arr[start1++];
        }
        while (start2 <= end2) {
            result[k++] = arr[start2++];
        }

        for (k = start; k <= end; k++) {
            arr[k] = result[k];
        }

    }

    // 快速排序
    // 按照从小到大排序
    private static void quickSort(int[] array, int head, int tail) {
        if (array == null || head >= tail || tail <= 1) {
            return;
        }
        int i = head, j = tail, pivot = array[(head + tail) / 2];
        while (i <= j) {
            while (array[i] < pivot) {
                ++i;
            }
            while (array[j] > pivot) {
                --j;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        quickSort(array, head, j);
        quickSort(array, i, tail);
    }

    // 插入
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tg = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > tg) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tg;
        }
    }

    // 选择排序
    private static void selectionSort(int[] arr) {
        int len = arr.length;
        if (len <= 0) {
            return;
        }
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    // 堆排序
    private static void heapSort(int[] arr) {
        // 1.数组堆化，从最后一个叶子节点开始
        int len = arr.length;
        int beginIndex = (len >> 1) - 1;
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapfiy(arr, i, len - 1);
        }
        // 2.对堆化数据排序
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            maxHeapfiy(arr, 0, i - 1);
        }
    }

    private static void maxHeapfiy(int[] arr, int node, int end) {
        int left = (node << 1) + 1;
        int right = left + 1;
        if (left > end) {
            return;
        }
        int cMax = left;
        if (right <= end && arr[left] < arr[right]) {
            cMax = right;
        }
        if (arr[node] < arr[cMax]) {
            swap(arr, cMax, node);
            maxHeapfiy(arr, cMax, end);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
