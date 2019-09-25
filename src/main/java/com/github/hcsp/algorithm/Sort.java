package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array3 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array4 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array5 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        long s1 = System.nanoTime();
        sort1(array1);
        long s2 = System.nanoTime();
        sort2(array2);
        long s3 = System.nanoTime();
        sort3(array3);
        long s4 = System.nanoTime();
        sort4(array4);
        long s5 = System.nanoTime();
        sort5(array5);
        long s6 = System.nanoTime();
        System.out.println(Arrays.toString(array1));
        System.out.println("冒泡排序所用时间：" + (s2 - s1) + "纳秒");
        System.out.println(Arrays.toString(array2));
        System.out.println("快速排序所用时间：" + (s3 - s2) + "纳秒");
        System.out.println(Arrays.toString(array3));
        System.out.println("插入排序所用时间：" + (s4 - s3) + "纳秒");
        System.out.println(Arrays.toString(array4));
        System.out.println("选择排序所用时间：" + (s5 - s4) + "纳秒");
        System.out.println(Arrays.toString(array5));
        System.out.println("堆排序所用时间：" + (s6 - s5) + "纳秒");
    }

    //冒泡排序
    public static void sort1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }

    //快速排序
    public static void sort2(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }

        int i = left;
        int j = right;
        //将最左边的数定义为基准轴
        int basisAxis = array[i];
        //当两个指针不相遇的时候进行检索
        while (i != j) {
            //先从右往左检索比基准轴小的数
            while (array[j] >= basisAxis && i < j) {
                j--;
            }
            //从左往右找一个的大于基准轴的数
            while (array[i] <= basisAxis && i < j) {
                i++;
            }
            swap(array, i, j);
        }
        //两指针相遇，则交换基准数与相遇位置处的元素交换数值
        array[left] = array[i];
        array[i] = basisAxis;
        //基准数字归为后，排左边的数
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }

    //插入排序
    public static void sort3(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    public static void sort4(int[] array) {
        selectSort(array);
    }

    //选择排序
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            swap(array, i, index);
        }
    }

    //堆排序
    public static void sort5(int[] array) {
        heapSort(array);
    }

    public static void heapSort(int[] array) {
        buildHeap(array, array.length);
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, i, 0);
            heapify(array, i, 0);
        }
    }

    //将数组进行堆化
    public static void heapify(int[] array, int number, int treeNode) {
        if (treeNode >= number) {
            return;
        }
        int leftChild = 2 * treeNode + 1;
        int rightChild = 2 * treeNode + 2;
        int index = treeNode;
        if ((leftChild < number) && (array[index] < array[leftChild])) {
            index = leftChild;
        }
        if ((rightChild < number) && (array[index] < array[rightChild])) {
            index = rightChild;
        }
        if (index != treeNode) {
            swap(array, index, treeNode);
            heapify(array, number, index);
        }
    }

    public static void buildHeap(int[] tree, int n) {
        int parent = (n - 2) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(tree, n, i);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
