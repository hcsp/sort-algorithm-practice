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
    public static void sort1(int[] array) {
        QuickSort(array, array.length);
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        MergeSort(array, array.length);
    }

    // 冒泡排序
    public static void BubbleSort(int[] array, int length) {
        if (LengthCheck(length)) {
            return;
        }

        for (int i = length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // 快速排序
    public static void QuickSort(int[] array, int length) {
        if (LengthCheck(length)) {
            return;
        }

        QuickMerge(array, 0, length - 1);
    }

    private static void QuickMerge(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int s = start;
        int e = end;

        int middle = array[start];
        while (s < e) {
            while (array[e] > middle && s < e) {
                --e;
            }
            array[s] = array[e];

            if (s < e) {
                ++s;
            } else {
                break;
            }

            while (array[s] <= middle && s < e) {
                ++s;
            }
            array[e] = array[s];
            if (s < e) {
                --e;
            }
        }
        array[s] = middle;

        QuickMerge(array, start, s - 1);
        QuickMerge(array, s + 1, end);
    }

    // 归并排序
    public static void MergeSort(int[] array, int length) {
        if (LengthCheck(length)) {
            return;
        }

        Merge(array, 0, length - 1);
    }

    private static void Merge(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = (start + end) / 2;
        Merge(array, start, middle);
        Merge(array, middle + 1, end);

        int[] newArray = new int[end - start + 1];
        int loc1 = start;
        int loc2 = middle + 1;
        for (int i = 0; i <= newArray.length - 1; ++i) {
            if (loc1 > middle) {
                System.arraycopy(array, loc2, newArray, i, end - loc2 + 1);
                break;
            }
            if (loc2 > end) {
                System.arraycopy(array, loc1, newArray, i, middle - loc1 + 1);
                break;
            }
            newArray[i] = array[loc1] < array[loc2] ? array[loc1++] : array[loc2++];
        }
        System.arraycopy(newArray, 0, array, start, newArray.length);
    }

    // 插入排序
    public static void InsertSort(int[] array, int length) {
        if (LengthCheck(length)) {
            return;
        }

        for (int i = 1; i < length; ++i) {
            int num = array[i];
            int j = i - 1;
            while (j >= 0) {
                if (array[j] > num) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
                --j;
            }
            array[j + 1] = num;
        }
    }

    // 选择排序
    public static void SelectSort(int[] array, int length) {
        if (LengthCheck(length)) {
            return;
        }

        for (int i = 0; i < length - 1; ++i) {
            int min = i;
            for (int j = i + 1; j < length; ++j) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

    // 堆排序
    public static void HeapSort(int[] array, int length) {
        if (LengthCheck(length)) {
            return;
        }

        int[] array1 = new int[length + 1];
        System.arraycopy(array, 0, array1, 1, length);

        for (int i = length; i > 1; --i) {
            HeapFall(array1, i);
            array1[0] = array1[1];
            array1[1] = array1[i];
            array1[i] = array1[0];
        }

        System.arraycopy(array1, 1, array, 0, length);
    }

    private static void HeapFall(int[] heap, int size) {
        for (int i = size / 2; i > 0; --i) {
            int max = 2 * i;
            if (2 * i + 1 <= size) {
                max = heap[2 * i] > heap[2 * i + 1] ? (2 * i) : (2 * i + 1);
            }
            if (heap[max] > heap[i]) {
                int temp = heap[i];
                heap[i] = heap[max];
                heap[max] = temp;
            }
        }
    }

    // 长度检查，true为不用排序
    private static boolean LengthCheck(int length) {
        return length < 2;
    }
}
