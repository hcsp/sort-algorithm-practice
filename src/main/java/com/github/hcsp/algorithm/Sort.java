package com.github.hcsp.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        sort1(array1);
        sort2(array1);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));

    }

    // 排序算法1
    // 按照从小到大排序
    public static void sort1(int[] array) {
        for (int j = 1; j < array.length; j++) {
            for (int i = 0; i < array.length - j; i++) {
                if (array[i] > array[i + 1]) {
                    exchangeValue(array, i, i + 1);
                }
            }
        }
    }

    // 快速排序
    public static void sort2(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int head, int tail) {
        if (tail <= head) {
            return;
        }
        List<Integer> newBound = splitIndex(array, head, tail);
        int newLeft = newBound.get(0);
        int newRight = newBound.get(1);
        quickSort(array, head, newLeft - 1);
        quickSort(array, newRight + 1, tail);
    }

    private static List<Integer> splitIndex(int[] array, int left, int right) {
        List<Integer> newBound = new ArrayList<>();
        int splitValue = array[left];
        int mainIndex = left + 1;
        while (mainIndex <= right) {
            if (array[mainIndex] < splitValue) {
                exchangeValue(array, left++, mainIndex++);
            } else if (array[mainIndex] > splitValue) {
                exchangeValue(array, right--, mainIndex);
            } else {
                mainIndex++;
            }
        }
        newBound.add(left);
        newBound.add(right);
        return newBound;
    }

    private static void exchangeValue(int[] array, int eligibleIndex, int mainIndex) {
        int newValue = array[mainIndex];
        array[mainIndex] = array[eligibleIndex];
        array[eligibleIndex] = newValue;
    }

    //归并排序
    public static void sort3(int[] array) {
        int[] copyArray = new int[array.length];
        mergeSort(array, copyArray, 0, array.length - 1);
    }

    public static void mergeSort(int[] array, int[] copyArray, int head, int tail) {
        if (tail <= head) {
            return;
        }
        int mid = (head + tail) / 2;
        mergeSort(array, copyArray, head, mid);
        mergeSort(array, copyArray, mid + 1, tail);
        merge(array, copyArray, head, mid, tail);
    }

    public static void merge(int[] array, int[] copyArray, int head, int mid, int tail) {
        copyArray = array.clone();
        int leftIndex = head;
        int rightIndex = mid + 1;
        for (int mainIndex = head; mainIndex < tail + 1; mainIndex++) {
            if (leftIndex > mid) {
                array[mainIndex] = copyArray[rightIndex++];
            } else if (rightIndex > tail) {
                array[mainIndex] = copyArray[leftIndex++];
            } else if (copyArray[leftIndex] > copyArray[rightIndex]) {
                array[mainIndex] = copyArray[rightIndex++];
            } else {
                array[mainIndex] = copyArray[leftIndex++];
            }
        }
    }

    //插入排序
    public static void sort5(int[] array) {
        int copyValue;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    copyValue = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = copyValue;
                } else {
                    break;
                }
            }
        }
    }

    //选择排序
    public static void sort6(int[] array) {
        int copyValue;
        int min;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                } else {
                    continue;
                }
            }
            copyValue = array[i];
            array[i] = array[min];
            array[min] = copyValue;
        }
    }
}
