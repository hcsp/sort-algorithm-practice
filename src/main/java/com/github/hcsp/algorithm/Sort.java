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

    // 冒泡排序
    // 按照从小到大排序
    public static void sort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // 插入排序
    // 按照从小到大排序
    public static void sort2(int[] array) {
        int j;
        int temp;
        //遍历整个数组
        for (int i = 1; i < array.length; i++) {
            //如果发现反序就将当前位置存入临时变量temp
            if (array[i] < array[i - 1]) {
                temp = array[i];
                //从当前位置向前遍历，并且吧每个元素与temp比较，如果大于temp就覆盖掉后一个元素
                for (j = i - 1; j >= 0 && temp < array[j]; j--) {
                    array[j + 1] = array[j];
                }
                //temp归位,如果当前元素不符合>temp，指针会停在前一个位置
                array[j + 1] = temp;
            }
        }
    }
}
