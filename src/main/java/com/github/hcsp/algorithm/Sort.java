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
        int n, m, j;
        for (n = 0; n < array.length - 1; n++) {
            for (m = 0; m < array.length - 1; m++) {
                if (array[m] >= array[m + 1]) {
                    j = array[m];
                    array[m] = array[m + 1];
                    array[m + 1] = j;
                }
            }
        }
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        int j, n, m;
        for (j = 1; j <= array.length - 1; j++) {
            for (n = j - 1; n >= 0; n--) {
                if (array[j] < array[n]) {
                    m = array[j];
                    array[j] = array[n];
                    array[n] = m;
                    j = j - 1;
                }
            }
        }
    }
}
