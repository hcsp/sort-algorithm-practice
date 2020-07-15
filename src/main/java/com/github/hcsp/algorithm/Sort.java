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
    //
    public static void sort1(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            //先每个数字都检查一遍，有没有需要对调的
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            //如果没有需要对调的，就结束循环
            if (!flag) {
                break;
            }
        }
    }

    // 排序算法2
    // 按照从小到大排序
    // 快速排序：
    public static void sort2(int[] array) {
        //先定义一个方法，传入数组，left,right，进行分治递归
        quickStore(array, 0, array.length - 1);
    }

    private static void quickStore(int[] array, int left, int right) {
        // 设置过滤条件，数组不是空的并且数组长度不小于2,
        // 第一层递归返回的基准值mid != 0,说明最左边弄完了，
        // 第二层递归返回的基准值mid+1 不能> right,不然会超出数组最大值array[right+1]，找不到后报错
        if (!(array == null) && !(array.length < 2) && !(left >= right)) {
            //进行分治并返回一个基准为下一个递归参数里的最大值
            int mid = partition(array, left, right);
            //第一层递归：向左递归找到数组中最小的数并且放到最左边
            quickStore(array, left, mid);
            //第二层递归：排除掉第一层递归后最左边已经确定位置的的数字，把起始值设置成确定后的值mid+1,
            // 继续循环第一层递归找到第2、3、4...直到全部确定完成，这个速度会几何倍的增快
            quickStore(array, mid + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int temp = array[left];
        while (left < right) {
            // 先把基准与(从后向前直到left的后一个数)依次进行比较,
            // 找到比基准小的数
            while (temp <= array[right] && right > left) {
                --right;
            }
            //如果找到比基准小的数就填到left坑里
            if (temp > array[right]) {
                array[left] = array[right];
                ++left;
            }
            // 先把基准与(从前向后直到right)依次进行比较,
            // 找到比基准大的数
            while (temp >= array[left] && left < right) {
                ++left;
            }
            //如果找到比基准大的数就填坑到上一个right里
            if (temp < array[left]) {
                array[right] = array[left];
                --right;
            }
        }
        //循环结束，有两种可能就是left >= right;
        // 第一种 left > right，这个可能非常少见，一般出现在队列中有跟基准同样的数字，它的左边紧挨着一个比它大的数字的时候
        //另一种可能就是没找到，结果left = right 并且下一个If条件进不去，
        // 将array[left]作为下一个递归的right或者left返回
        array[left] = temp;
        return left;
    }
}
