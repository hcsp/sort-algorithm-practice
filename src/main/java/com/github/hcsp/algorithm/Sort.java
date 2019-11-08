package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array3 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};

        sort1(array1);
        sort2(array2);
        sort3(array3);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
    }

    // 排序算法1
    // 按照从小到大排序
    public static void sort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

    // 排序算法3
    public static void sort3(int[] array) {
        sort3Helper(array, 0, array.length - 1);
    }

    public static void sort3Helper(int[] array, int start, int end) {
        int i = start;
        int j = end;
        int k = (start + end) / 2;
        if (start == end) {
            return;
        }
        while (array[i] < array[k]) {
            i++;
        }
        while (array[k] < array[j]) {
            j--;
        }
        if (i < j) {
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
            i++;
            j--;
        } else if (i == j) {
            i++;
        }
        sort3Helper(array, start, j);
        sort3Helper(array, i, end);
    }
}
