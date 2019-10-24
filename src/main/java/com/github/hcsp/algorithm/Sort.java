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
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        if (array.length > 0) {
            sort2(array, 0, array.length - 1);
        }
    }


    //快速排序
    public static void sort2(int[] array, int start, int end) {

        //设置递归出口
        if (start > end) {
            return;
        }

        int i = start;
        int j = end;
        int key = array[start];


        //第一趟排序
        while (i < j) {
            while (i < j && array[j] > key) {
                j--;
            }
            while (i < j && array[i] <= key) {
                i++;
            }
            int tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
        }

        int tmp = array[i];
        array[i] = array[start];
        array[start] = tmp;

        sort2(array, start, i - 1);
        sort2(array, i + 1, end);
    }
}

