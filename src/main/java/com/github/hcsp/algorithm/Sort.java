package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};

        // 按照从小到大排序
        sort1(array1);
        sort2(array2);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    // 排序算法1 冒泡排序
    // 时间复杂度 n^2
    // 稳定性 稳定
    public static void sort1(int[] array) {
        int size = array.length;

        // 外层只需要 size-1 次循环，每次确定索引为 size-1-i 上的值
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // 交换
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    // 排序算法2 快速排序
    // 时间复杂度 nlogn
    // 稳定性 不稳定
    public static void sort2(int[] array) {
        // 异常输入情况
        if (array == null || array.length == 0 || array.length == 1) {
            return;
        }
        recursionOption(array, 0, array.length - 1);
    }

    private static void recursionOption(int[] array, int begin, int end) {
        // 递归实现快速排序
        if (begin > end) {
            // 递归终止条件
            return;
        }
        // 选取左边的为基准，则右边指针先移动
        int baseIndex = begin;
        // 从两头分别找大于和小于基准的值，并交换
        int i, j;
        for (i = begin, j = end; i < j; ) {
            // 从右往左找小于基准的数，时刻保证 i<j
            while (i < j && array[j] >= array[baseIndex]) {
                j--;
            }
            // 从左边找到大于基准的数，时刻保证 i<j
            while (i < j && array[i] <= array[baseIndex]) {
                i++;
            }


            if (i < j) {
                // 交换二者
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        //i==j 将基准放到中间
        int swap = array[i];
        array[i] = array[baseIndex];
        array[baseIndex] = swap;
        // 左边继续递归排序
        recursionOption(array, begin, i - 1);
        // 右边继续递归排序
        recursionOption(array, i + 1, end);
    }
}
