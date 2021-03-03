package com.github.hcsp.algorithm;

import java.util.Arrays;


public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array3 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        sort1(array1);
        sort2(array2);
        sort2(array3);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
    }

    // 冒泡排序
    // 按照从小到大排序
    public static void sort1(int[] array) {
        bubbleSort(array, array.length - 1);
    }

    private static void bubbleSort(int[] array, int end) {
        if (end != 0) {
            for (int i = 0; i < end; i++) {
                for (int j = 0; j < end - i; j++) {
                    if (array[j] > array[j + 1]) {
                        mySwap(array, j, j + 1);
                    }
                }
            }
        }
    }

    private static void mySwap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    // 含有相等元素的归并排序
    // 按照从小到大排序
    public static void sort2(int[] array) {
        int[] result = new int[array.length];
        mergeSort(array, 0, array.length - 1, result);
    }

    private static void mergeSort(int[] array, int startIndex, int endIndex, int[] result) {
        if (startIndex < endIndex) {
            int midIndex = (endIndex - startIndex) / 2 + startIndex;
            mergeSort(array, startIndex, midIndex, result);
            mergeSort(array, midIndex + 1, endIndex, result);
            int recurIndex_1 = startIndex;
            int k = startIndex;
            int recurIndex_2 = midIndex + 1;
            while (recurIndex_1 <= midIndex && recurIndex_2 <= endIndex) {
                if (array[recurIndex_1] <= array[recurIndex_2]) {
                    result[k++] = array[recurIndex_1++];
                } else {
                    result[k++] = array[recurIndex_2++];
                }
            }
            while (recurIndex_1 <= midIndex) {
                result[k++] = array[recurIndex_1++];
            }
            while (recurIndex_2 <= endIndex) {
                result[k++] = array[recurIndex_2++];
            }
            System.arraycopy(result, startIndex, array, startIndex, endIndex + 1 - startIndex);
        }
    }

    public static void sort3(int[] array) {
        if (array.length == 0 || array.length == 1) {
        } else {
            int key, j;
            int arrayLength = array.length;
            for (int i = 1; i < array.length - 1; i++) {
                key = array[i];
                j = i - 1;
                while (j >= 0 && array[j] > key) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = key;
            }
        }
    }
}
