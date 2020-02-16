package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[] {4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[] {4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array3 = new int[] {4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        sort1(array1);
        sort2(array2);
        sort3(array3);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
    }

    // 排序算法1
    // 按照从小到大排序
    // 冒泡排序
    public static void sort1(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // 排序算法2
    // 按照从小到大排序
    // 快速排序
    public static void quicksort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int base = array[left];
        int i = left, j = right;
        while (i != j) {
            while (array[j] >= base && i < j) {
                --j;
            }
            while (array[i] <= base && i < j) {
                ++i;
            }
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        array[left] = array[i];
        array[i] = base;
        quicksort(array, left, i - 1);
        quicksort(array, i + 1, right);
    }

    public static void sort2(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    public static void sort3(int[] array){
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i-1;
            while (j >= 0 &&array[j]>key){
                array[j+1]= array[j];
                j--;
            }
            array[j+1] = key;
        }
    }



}
