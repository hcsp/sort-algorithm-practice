package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array3 = {4789, 135169, 1589, 1, 9, 123, 67, 1245, 125, 774, 15125, 12556, 9912590};
        sort1(array1);
        sort2(array2);
        sort1(array3);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
    }

    public static void bubbleSort(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i; j++) {
                int currentNumber = array[j];
                int nextNumber = array[j + 1];
                if (currentNumber > nextNumber) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    // 排序算法1
    // 按照从小到大排序
    public static void sort1(int[] array) {
        bubbleSort(array);
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        insertionSort(array);
    }

    private static void insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int currentElement = array[i];
            int targetIndex = i - 1;
            while (targetIndex >= 0 && (array[targetIndex] > currentElement)) {
                array[targetIndex + 1] = array[targetIndex];
                targetIndex--;
            }
            array[targetIndex + 1] = currentElement;
        }
    }

    private static void quickSort(int[] array) {
//        http://www.ruanyifeng.com/blog/2011/04/quicksort_in_javascript.html
    }
}
