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
        bubbleSort(array);
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        mergeSort(array);
    }

    // 冒泡
    private static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j + 1] < array[j]) {
                    swapArrayElement(array, j, j + 1);
                }
            }
        }
    }

    private static void swapArrayElement(int[] array, int low, int high) {
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }

    // 归并
    private static void mergeSort(int[] array) {
        int start = 0;
        int end = array.length - 1;
        mergeSortRecursive(array, start, end);
    }

    private static void mergeSortRecursive(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        // 分解
        int mid = start + (end - start) / 2;
        mergeSortRecursive(array, start, mid);
        mergeSortRecursive(array, mid + 1, end);

        // 合并
        int[] tmpArr = new int[end - start + 1];
        int tmpIndex = 0;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            if (array[left] < array[right]) {
                tmpArr[tmpIndex] = array[left];
                left++;
            } else {
                tmpArr[tmpIndex] = array[right];
                right++;
            }
            tmpIndex++;
        }
        while (left <= mid) {
            tmpArr[tmpIndex++] = array[left++];
        }
        while (right <= end) {
            tmpArr[tmpIndex++] = array[right++];
        }

        for (int i = 0; i <= end-start; i++) {
            array[start + i] = tmpArr[i];
        }
    }

}
