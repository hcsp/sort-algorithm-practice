package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        sort6(array1);
        System.out.println(Arrays.toString(array1));
    }

    // 抽象方法，用来交换元素
    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    // 冒泡排序
    public static void sort1(int[] array) {
        int length = array.length;
        for (int i = length; i > 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
//                    int temp = array[j];
//                    array[j] = array[j+1];
//                    array[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    // 直接插入排序
    public static void sort2(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int num = array[i];
            int index;
            for (index = i; index > 0 && array[index - 1] > num; index--) {
                array[index] = array[index - 1];
            }
            array[index] = num;
        }
    }

    // 选择排序
    public static void sort3(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int min = array[i];
            int index = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }
            if (index != i) {
                swap(array, index, i);
            }
        }
    }

    // 快速排序
    public static void sort4(int[] array) {
        help(array, 0, array.length - 1);
    }

    public static void help(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = array[start];
        int low = start, high = end;
        while (low < high) {
            while (low <= high && array[low] <= pivot) {
                low++;
            }
            while (low <= high && array[high] >= pivot) {
                high--;
            }
            if (low < high) {
                swap(array, low, high);
            }
        }
        swap(array, start, high);
        help(array, start, high - 1);
        help(array, high + 1, end);
    }

    // 归并排序
    public static void sort5(int[] array) {
        mergerSort(array, 0, array.length - 1);
    }

    public static void mergerSort(int[] array, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergerSort(array, start, mid);
        mergerSort(array, mid + 1, end);
        merge(array, start, mid + 1, end);
    }

    public static void merge(int[] array, int start, int mid, int end) {
        int[] left = new int[mid - start];
        int[] right = new int[end - mid + 1];

        for (int i = start; i < mid; i++) {
            left[i - start] = array[i];
        }
        for (int i = mid; i <= end; i++) {
            right[i - mid] = array[i];
        }
        int i = 0, j = 0, k = start;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    //堆排序
    public static void sort6(int[] array) {
//        heapSort(array, array.length - 1);
        buildMaxHeap(array, array.length - 1);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, i, 0);
            adjustDown(array, 0, i - 1);
        }
    }

    private static void buildMaxHeap(int[] array, int length) {
        for (int i = length / 2; i >= 0; i--) {
            adjustDown(array, i, length);
        }
    }

    private static void adjustDown(int[] array, int k, int length) {
        int temp = array[k];
        for (int i = k * 2 + 1; i <= length; i = 2 * i + 1) {
            if (i < length && array[i] < array[i + 1]) {
                i++;
            }
            if (temp >= array[i]) {
                break;
            } else {
                array[k] = array[i];
                k = i;
            }
        }
        array[k] = temp;
    }
}
