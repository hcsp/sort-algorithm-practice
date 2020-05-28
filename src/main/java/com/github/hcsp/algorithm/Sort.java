package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[] { 4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0 };
        int[] array2 = new int[] { 4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0 };
        int[] array3 = new int[] { 4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0 };
        int[] array4 = new int[] { 4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0 };
        int[] array5 = new int[] { 4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0 };
        int[] array6 = new int[] { 4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0 };
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

    // 排序算法1- bubble sort
    // 按照从小到大排序
    public static void sort1(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int bridge = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = bridge;
                }
            }
        }
    }

    // 排序算法2- quick sort
    // 按照从小到大排序
    public static void sort2(int[] array) {
        int left = 0, right = array.length - 1;
        quickSort(array, left, right);
    }

    public static int division(int[] array, int left, int right) {
        int pivot = array[left];
        while (left < right) {
            while (left < right && array[right] >= pivot) {
                right--;
            }
            array[left] = array[right];

            while (left < right && array[left] <= pivot) {
                left++;
            }
            array[right] = array[left];

        }
        array[left] = pivot;
        return left;
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int base = division(array, left, right);
            quickSort(array, left, base - 1);
            quickSort(array, base + 1, right);
        }
    }

    // 排序算法3-SELECT SORT
    // 按照从小到大排序
    public static void sort3(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minKey = array[i];
            for (int j = i; j < array.length; j++) {
                if (minKey > array[j]) {
                    int bridge = array[j];
                    array[j] = minKey;
                    minKey = bridge;
                }
            }
            array[i] = minKey;
        }
    }

    // 排序算法4- insert sort
    // 按照从小到大排序
    public static void sort4(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i;
            while (j > 0 && tmp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            if (j != i) {
                array[j] = tmp;
            }
        }
    }

    // 排序算法5-heap sort
    // 按照从小到大排序
    public static void sort5(int[] array) {
        int len = array.length;
        buildHeap(array, len);
        for (int i = len - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            len--;
            toHeap(array, 0, len);
        }
    }

    public static void buildHeap(int[] array, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            toHeap(array, i, len);
        }
    }

    public static void toHeap(int[] array, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < len && array[left] > array[largest]) {
            largest = left;
        }
        if (right < len && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            toHeap(array, largest, len);
        }
    }

    // 排序算法6-merge sort
    // 按照从小到大排序
    public static void sort6(int[] array) {
        int[] finalResult = mergeSort(array);
        for (int i = 0; i <finalResult.length; i++) {
            array[i] = finalResult[i];
        }
    }

    public static int[] mergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int middle = (int) Math.floor(array.length / 2);
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }

}
