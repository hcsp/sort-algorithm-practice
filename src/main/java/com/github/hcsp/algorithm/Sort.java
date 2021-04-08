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

    // 排序算法1-冒泡排序 时间复杂度O(n^2) 从小到大
    public static void sort1(int[] array) {
        boolean flag = false; //优化---是否进行过交互
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    int swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
            // 如果一次交互都没有发生，选择排序时间复杂度O(n^2)
            if (flag) {
                break;
            } else {
                flag = false; //重制flag，进行下次交换
            }
        }

    }

    // 排序算法2-选择排序 时间复杂度O(n^2) 从小到大
    public static void sort2(int[] array) {
        // 1、外层循环控制几轮
        for (int i = 0; i < array.length; i++) {
            //2、定义一个循环控制比较几次，一定是以当前位置与后面的元素比较
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    // 获取当前位置的值
                    int currentLocation = array[j];
                    array[j] = array[i];
                    array[i] = currentLocation;
                }
            }
        }
    }
}
