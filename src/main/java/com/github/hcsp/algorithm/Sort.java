package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[] {4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[] {4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        sort1(array1);
        sort2(array2, 0, array2.length - 1);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    // 排序算法1 --- 冒泡
    // 按照从小到大排序
    public static void sort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) { // n个数比较需要 n-1 趟，每趟确定一个最大值/最小值， 放在两端
            for (int j = 0; j < array.length - 1 - i; j++) { // 每趟都能确定一个最大/小值， 所以下一趟就可以少比较一次
                if (array[j] > array[j+1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    // 排序算法2 --- 快排
    // 按照从小到大排序
    public static void sort2(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left, j = right;
        while (i != j) {
            while (array[j] >= array[left] && i < j) {
                j--;
            }
            while (array[i] <= array[left] && i < j) {
                i++;
            }
            if (i < j) {
              swap(array, i, j);
            }
        }
        swap(array, left, i);
        sort2(array, left, i - 1);
        sort2(array, i + 1, right);
    }

    static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
