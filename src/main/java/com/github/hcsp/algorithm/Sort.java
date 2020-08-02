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

    // 排序算法1 冒泡
    // 按照从小到大排序
    public static void sort1(int[] array) {
        // 相邻的相比，大的互换位置,每比较一趟会把一个最大的排到最后
        for (int x = 0; x < array.length - 1; x++) { // 第几趟
            for (int y = 0; y < array.length - 1 - x; y++) { // 每趟比较次数
                if (array[y] > array[y + 1]) {
                    int tem;
                    tem = array[y];
                    array[y] = array[y + 1];
                    array[y + 1] = tem;
                }
            }
        }
    }

    // 排序算法2 插入
    // 按照从小到大排序
    public static void sort2(int[] a) {
        int i, j, insertNote;// 要插入的数据
        for (i = 1; i < a.length; i++) {// 从数组的第二个元素开始循环将数组中的元素插入
            insertNote = a[i];// 设置数组中的第2个元素为第一次循环要插入的数据
            j = i - 1;
            while (j >= 0 && insertNote < a[j]) {
                a[j + 1] = a[j];// 如果要插入的元素小于第j个元素,就将第j个元素向后移动
                j--;
            }
            a[j + 1] = insertNote;// 直到要插入的元素不小于第j个元素,将insertNote插入到数组中
        }
    }
}
