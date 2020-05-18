package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array3 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array4 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array5 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array6 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};

        sort1(array1);
        sort2(array2);
        sort3(array3);
        sort4(array4);
        sort5(array5);
        sort6(array6);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));
        System.out.println(Arrays.toString(array5));
        System.out.println(Arrays.toString(array6));
    }

    // 1.冒泡排序
    // 按照从小到大排序
    public static void sort1(int[] array) {
        bubbleSort(array);
    }

    private static void bubbleSort(int[] array) {
        int len = array.length;
        // 需要 length-1 轮
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] array, int one, int another) {
        int tmp = array[one];
        array[one] = array[another];
        array[another] = tmp;
    }

    // 2.快速排序
    // 按照从小到大排序
    public static void sort2(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(array, start, end);
        // 分治
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        // 支点
        int pivot = array[start];
        // 临时边界
        int mark = start;

        // 扩大临时边界，使边界左边元素均小于pivot
        for (int i = start + 1; i <= end; i++) {
            if (array[i] < pivot) {
                swap(array, i, ++mark);
            }
        }

        // 用pivot替换mark边界
        swap(array, start, mark);
        return mark;
    }

    // 3.归并排序
    // 按照从小到大排序
    public static void sort3(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            // 分治
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            // 合并
            merge(array, start, mid, end);
        }
    }

    private static void merge(int[] array, int start, int mid, int end) {
        // 记录两段数组的起点
        int part1Start = start;
        int part2Start = mid + 1;

        // 新建临时数组
        int[] arr = new int[end - start + 1];
        int k = 0;

        // 有序地复制到临时数组
        for (int i = start; i <= end; i++) {
            // 第一段数组元素用光，复制第二段元素到临时数组
            if (part1Start > mid) {
                arr[k++] = array[part2Start++];
            }
            // 第二段数组元素用光，复制第一段元素到临时数组
            else if (part2Start > end) {
                arr[k++] = array[part1Start++];
            }
            // 比较两个数组最前面的元素，将较小的复制到临时数组
            else if (array[part1Start] < array[part2Start]) {
                arr[k++] = array[part1Start++];
            } else {
                arr[k++] = array[part2Start++];
            }
        }

        // 复制临时数组的元素到原数组
        for (int i = 0; i < k; i++) {
            array[start++] = arr[i];
        }
    }

    // 4.插入排序
    // 按照从小到大排序
    public static void sort4(int[] array) {
        insertionSort(array);
    }

    private static void insertionSort(int[] array) {
        int len = array.length;
        // 需要 length-1 轮
        for (int i = 1; i < len; i++) {
            int tmp = i;
            for (int j = i - 1; j >= 0; j--) {
                if (array[tmp] < array[j]) {
                    swap(array, j, tmp);
                    tmp = j;
                }
            }
        }
    }

    // 5.选择排序
    // 按照从小到大排序
    public static void sort5(int[] array) {
        selectionSort(array);
    }

    private static void selectionSort(int[] array) {
        int len = array.length;
        // 需要 length-1 轮
        for (int i = 0; i < len - 1; i++) {
            // 保存该轮排序最大值下标
            int max = 0;
            for (int j = 1; j < len - i; j++) {
                if (array[max] < array[j]) {
                    max = j;
                }
            }
            swap(array, len - 1 - i, max);
        }
    }

    // 6.堆排序
    // 按照从小到大排序
    public static void sort6(int[] array) {
        heapSort(array);
    }

    private static void heapSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        // 构建最大堆
        for (int i = 0; i < array.length; i++) {
            heapInsert(array, i);
        }
        int size = array.length;
        swap(array, 0, --size);
        while (size > 0) {
            heapify(array, 0, size);
            swap(array, 0, --size);
        }
    }

    private static void heapify(int[] array, int index, int size) {
        // 左孩子
        int left = index * 2 + 1;
        while (left < size) {
            // 求根左右中最大值
            int max = ((left + 1 < size) && (array[left + 1] > array[left])) ? left + 1 : left;
            max = array[index] > array[max] ? index : max;
            // 根节点为最大值，获得最大堆
            if (max == index) {
                break;
            }
            swap(array, index, max);
            index = max;
            left = index * 2 + 1;
        }
    }

    private static void heapInsert(int[] array, int index) {
        // 保证子节点小于根节点
        while (array[index] > array[(index - 1) / 2]) {
            swap(array, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

}
