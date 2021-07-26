package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
//        int[] array2 = new int[]{8, 4, 1, 7, 4};

        sort1(array1);
        sort2(array2);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    // 归并排序 - 递归法
    // 按照从小到大排序
    public static void sort1(int[] array) {
        mergeSort(array);
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        mergeSort2(array);
    }

    // 归并排序 - 迭代法
    // 1. 将序列每相邻两个数字进行归并操作，形成ceil(n/2)个序列，排序后每个序列包含两/一个元素
    // 2. 若此时序列数不是1个则将上述序列再次归并，形成ceil(n/4)个序列，每个序列包含四/三个元素
    // 3. 重复步骤2，直到所有元素排序完毕，即序列数为1
    public static void mergeSort2(int[] array) {
        int[] orderedArray = new int[array.length];
        for (int childArrayLength = 2; childArrayLength < array.length * 2; childArrayLength *= 2) {
            for (int j = 0; j <= (array.length - 1) / childArrayLength; j++) {
                int low = childArrayLength * j;
                int high = Math.min((low + childArrayLength - 1), (array.length - 1));
                int mid = Math.min(low + childArrayLength / 2 - 1, array.length - 1);

                merge(array, orderedArray, low, mid, mid + 1, high, low);
                System.arraycopy(orderedArray, low, array, low, high + 1 - low);
            }
        }
    }

    // 归并排序 - 递归法
    // 1. 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
    // 2. 设定两个指针，最初位置分别为两个已经排序序列的起始位置
    // 3. 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
    // 4. 重复步骤3直到某一指针到达序列尾
    // 5. 将另一序列剩下的所有元素直接复制到合并序列尾
    public static void mergeSortRecursive(int[] array, int[] result, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = ((high - low) >> 1) + low;
        mergeSortRecursive(array, result, low, mid);
        mergeSortRecursive(array, result, mid + 1, high);
        merge(array, result, low, mid, mid + 1, high, low);

        if (high + 1 - low >= 0) {
            System.arraycopy(result, low, array, low, high + 1 - low);
        }
    }

    private static void merge(int[] array, int[] result, int start1, int end1, int start2, int end2, int resultIndex) {
        // 将左侧数组和右侧数组进行对比，将更小的值写入 result
        while (start1 <= end1 && start2 <= end2) {
            result[resultIndex++] = array[start1] < array[start2] ? array[start1++] : array[start2++];
        }

        // 将左侧数组剩余部分写入 result
        while (start1 <= end1) {
            result[resultIndex++] = array[start1++];
        }

        // 将右侧数组剩余部分写入 result
        while (start2 <= end2) {
            result[resultIndex++] = array[start2++];
        }
    }

    public static void mergeSort(int[] array) {
        int[] result = new int[array.length];
        int low = 0;
        int high = array.length - 1;
        mergeSortRecursive(array, result, low, high);
    }

    public static int partition(int[] array, int left, int right, int pivotIndex) {
        int pivotValue = array[pivotIndex];
        swapValueInArray(array, pivotIndex, right);
        int nextPivotIndex = left;
        for (int i = left; i < right; i++) {
            if (array[i] <= pivotValue) {
                swapValueInArray(array, i, nextPivotIndex);
                nextPivotIndex += 1;
            }
        }
        swapValueInArray(array, right, nextPivotIndex);
        return nextPivotIndex;
    }

    public static void quickSort(int[] array, int left, int right) {
        if (right > left) {
            int pivotNewIndex = partition(array, left, right, left);
            quickSort(array, left, pivotNewIndex - 1);
            quickSort(array, pivotNewIndex + 1, right);
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swapValueInArray(array, j, i);
                }
            }
        }
    }

    public static void swapValueInArray(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
