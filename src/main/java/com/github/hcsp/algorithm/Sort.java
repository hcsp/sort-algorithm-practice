package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[] {4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[] {4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        sort1(array1);
        sort2(array2);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));

    }

    // 排序算法1
    // 按照从小到大排序
    public static void sort1(int[] array) {
        int capacity = 0;
        //Bobble sort
        //大循环，loop n-1次
        for (int i = 0; i < array.length-1; i++){
            //小循环比较  loop (array.length-1)
            for (int j = 0; j < ((array.length-1)-i); j++){
                if (array[j]>array[j+1]){
                    capacity   = array[j+1];
                    array[j+1] = array[j];
                    array[j]   = capacity;
                }
            }
        }
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
            //Insert sort loop n次
        for (int i = 1; i< array.length; i++){
                int target = array[i];
                int j = i-1;

                while (j>=0){
                    if (array[j] > target){
                           array[j+1] = array[j];
                           array[j] = target;
                    }
                    j--;
                }
        }
    }
}
