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
    //冒泡排序第一次将最大的排到最后
    //第二次将剩下的重复上个步骤（N个数字冒泡排序，总共要进行N-1趟比较，每趟的排序次数为(N-i)次比较）
    public static void sort1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    // 排序算法2
    // 按照从小到大排序
    //快速排序
    public static void sort2(int[] array) {
        int left = 0;
        int right = array.length - 1;
        quikSort(left, right, array);
    }

    static void quikSort(int left, int right, int[] array) {
        if (left > right) {
            return;
        }
        int templeft = left;
        int tempright = right;
        int key = array[left];
        while (left < right) {
            //从右往左与key比较，找到小于基准值停下,
            while (key <= array[right] && left < right) {
                right--;
            }
            //从左往右找，找到大于基准值的跳出循环
            while (key >= array[left] && left < right) {
                left++;
            }
            //开始做交换
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        // 结束第一次基准值比较，交换基准值位置
        array[templeft] = array[left];
        array[left] = key;
        System.out.println(Arrays.toString(array));
        quikSort(templeft, left - 1, array);
        quikSort(right + 1, tempright, array);
    }
}
