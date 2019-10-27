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
        fastSort(array, 0, array.length - 1);
    }

    private static void fastSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int head = start, tail = end;
        int mid = array[(head + tail) / 2];
        while (head <= tail) {
            while (array[head] < mid) {
                head++;
            }
            while (array[tail] > mid) {
                tail--;
            }
            if (head == tail) {
                head++;
            } else if (head < tail) {
                int temp = array[head];
                array[head] = array[tail];
                array[tail] = temp;
                head++;
                tail--;
            }
        }
        fastSort(array, start, tail);
        fastSort(array, head, end);
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        boolean finished;
        int counts = array.length;
        do {
            int head = 0;
            counts--;
            finished = true;
            while (head < counts) {
                if (array[head] > array[head + 1]) {
                    int temp = array[head + 1];
                    array[head + 1] = array[head];
                    array[head] = temp;
                    finished = false;
                }
                head++;
            }
        } while (!finished);
    }
}
