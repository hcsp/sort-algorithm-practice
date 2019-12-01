package com.github.hcsp.algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < array.length; i++) {
            pq.offer(array[i]);
        }
        int index = 0;
        while (!pq.isEmpty()) {
            array[index++] = pq.poll();
        }
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        //quickSort(array, 0, array.length-1);
        Arrays.sort(array);
    }

    private static void quickSort(int[] array, int start, int end) {
        return;
    }
}
