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
    //冒泡排序
    public static void sort1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }

        }
    }

    // 排序算法2
    // 按照从小到大排序
    //快速排序
    static void qSort(int[] array, int head, int tail) {
        if (head >= tail || array == null || array.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = array[(head + tail) / 2];
            while (array[i] > pivot) {
                ++i;
            }
            while (array[j] < pivot) {
                --j;
            }
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
            qSort(array, head, j);
            qSort(array, i, tail);
        }

    public static void sort2(int[] array) {
             qSort(array, 0, array.length-1);
            }
}

