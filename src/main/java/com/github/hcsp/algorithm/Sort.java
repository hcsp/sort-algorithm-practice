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
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            for (int j = 0; j < (array.length - i - 1); j++) {
                int first = array[j];
                int second = array[j + 1];
                if (first > second) {
                    int temp = array[j];
                    array[j] = second;
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    // 排序算法2
    // 按照从小到大排序
    static int quickSortSplit(int[] array, int start, int end) {

        int standard = array[start];
        while (true) {
            while (true) {
                if (end <= start) {
                    break;
                }
                int rightVal = array[end];
                if (rightVal < standard) {
                    break;
                } else {
                    end -= 1;
                }
            }
            while (true) {
                if (end <= start) {
                    break;
                }
                int leftVal = array[start];
                if (leftVal >= standard) {
                    break;
                } else {
                    start += 1;
                }
            }
            if (end <= start) {
                break;
            } else {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
        return start;
    }

    public static void quickSort2(int[] array, int left, int right) {
        if (right - left <= 0) {
            return;
        }
        int middle = quickSortSplit(array, left, right);
        quickSort2(array, left, middle);
        quickSort2(array, middle + 1, right);
    }

    public static void sort2(int[] array) {
        int left = 0;
        int right = array.length - 1;
        quickSort2(array, left, right);
    }
}
