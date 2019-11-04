package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array3 = new int[]{1, 2, 1, 7, 2, 97, 6, 9, 3, 4, 0, 3, 4, 5, 7};

        sort1(array1);
        sort2(array2);
        quickSort(array3);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
    }

    // 排序算法1
    // 按照从小到大排序
    //冒泡排序
    public static void sort1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // 排序算法2
    // 按照从小到大排序
    //插入排序
    public static void sort2(int[] array) {
        int j;
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            j = i;
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    // 排序算法3
    // 按照从小到大排序
    //选择排序
    public static void sort3(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    // 排序算法4
    // 按照从小到大排序
    //快速排序
    public static void quickSort(int[] array) {
        sort4(array, 0, array.length - 1);
    }

    public static void sort4(int[] array, int left, int right) {
        if (left > right || array.length < 0) {
            return;
        }

        //基准值
        int key = array[left];
        int i = left;
        int j = right;


        while (i < j) {
            while (i < j && key < array[j]) { //从右向左寻找第一个小于基准值的数
                j--;
            }
            while (i < j && key >= array[i]) { //从左向右寻找第一个大于基准值的数
                i++;
            }

            if (i < j) { //如果此时，大于基准值的数的位置在小于基准值数的前面；进行交换
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        array[left] = array[i];
        array[i] = key;

        sort4(array, left, i - 1);
        sort4(array, i + 1, right);
    }

}
