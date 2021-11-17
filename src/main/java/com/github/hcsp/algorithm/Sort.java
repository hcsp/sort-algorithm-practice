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
        // 控制轮数,每一轮找出一个最大值
        for (int i = 0; i < array.length - 1; i++) {
            // 两两间比较,因为每一轮都已经找出了一个最大值,那么查找次数要依次递减
            // 例如第一轮,还没有找到最大值,那么就要查找所有元素进行比较
            // 第二轮,已经找到了一个最大值,那么就要-1个
            // 第三轮,已经找到了两个最大值,-2个
            // 以此类推,这就是为什么要 -i 的原因
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i; // 每一轮循环,先选择第一个数当成最小值
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (i != min) {
                swap(array, i, min);
            }
        }
    }

    private static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
