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

    public static void sort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort2(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int begin, int end) {
        if (begin < end) {
            int key = array[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                while (i < j && array[j] > key) {
                    j--;
                }
                if (i < j) {
                    array[i] = array[j];
                    i++;
                }
                while (i < j && array[i] < key) {
                    i++;
                }
                if (i < j) {
                    array[j] = array[i];
                    j--;
                }
            }
            array[i] = key;
            quickSort(array, begin, i - 1);
            quickSort(array, i + 1, end);
        }
    }
}
