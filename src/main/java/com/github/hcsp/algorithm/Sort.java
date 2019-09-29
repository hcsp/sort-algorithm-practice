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

    // 排序算法1，选择排序
    // 按照从小到大排序
    public static void sort1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }


    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    // 排序算法2，堆排序
    // 按照从小到大排序
    public static void sort2(int[] array) {
        int maxIndex = array.length;
        for (int k = maxIndex / 2; k >= 1; k--) {
            sink(array, k, maxIndex);
        }
        while (maxIndex > 1) {
            swap(array, 0, maxIndex - 1);
            maxIndex--;
            sink(array, 1, maxIndex);
        }

    }

    private static void sink(int[] array, int k, int arrLength) {
        while (2 * k <= arrLength) {
            int childNodeIndex = 2 * k;
            if (childNodeIndex < arrLength && array[childNodeIndex - 1] < array[childNodeIndex]) {
                childNodeIndex++;
            }

            if (array[k - 1] >= array[childNodeIndex - 1]) {
                break;
            }
            swap(array, k - 1, childNodeIndex - 1);
            k = childNodeIndex;
        }
    }

}
