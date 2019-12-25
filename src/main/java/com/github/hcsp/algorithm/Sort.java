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


    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 排序算法1
    // 按照从小到大排序
    //冒泡排序  O(n^2),最好：O(n)
    public static void sort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    // 排序算法2
    // 按照从小到大排序
    //快速排序 O(nlog2n)
    public static void sort2(int[] array) {
        //quickSort(array, 0, array.length - 1);
        mergeSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int low, int high) {

        if (low < high) {
            int i = low;
            int j = high;
            int key = array[low];
            while (i < j) {
                while (i < j && key < array[j]) {
                    j--;
                }
                if (i < j) {
                    array[i] = array[j];
                    i++;
                }

                while (i < j && key > array[i]) {
                    i++;
                }
                if (i < j) {
                    array[j] = array[i];
                    j--;
                }
            }
            array[i] = key;
            quickSort(array, low, i - 1);
            quickSort(array, i + 1, high);
        }
    }

    //归并排序

    /*
     * 其思想是分而治之，把一组数列不断的去对半分，直到分到两个都相等（最少两个数）然后就比较合并，
     * 合并的数列，还会继续分，mid的左右从最左比较，把小（大）放入零时空间中，放入后忘右移动一位
     * 最后会剩下一个数，从左右开始遍历，把所有数据放入零时数列中后，再放回原来的空间（数组中）
     *
     *
     */
    public static void mergeSort(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);

    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int l = left;
        int r = mid + 1;
        while (l <= mid && r <= right) {
            temp[i++] = array[l] > array[r] ? array[r++] : array[l++];
        }
        while (l <= mid) {
            temp[i++] = array[l++];
        }
        while (r <= right) {
            temp[i++] = array[r++];
        }
        for (int aTemp : temp) {
            array[left++] = aTemp;
        }

    }

    //插入排序
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    //折半插入排序
    public static void binaryInsertSort(int array[]) {
        int low;
        int high;
        int m; // 中间位置
        for (int i = 1; i < array.length; i++) {
            low = 0;
            high = i - 1;
            while (low <= high) {
                m = (low + high) / 2;
                if (array[m] > array[i]) {
                    high = m - 1;
                } else {
                    low = m + 1;
                }
            }
            int temp = array[i];
            for (int j = i; j > high + 1; j--) {
                array[j] = array[j - 1];
            }
            array[high + 1] = temp;
        }
    }

    //选择排序
    public static void selectionSort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            //从小到大
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }


    //堆排序

    /*
     * 挑选出所有的非叶子节点，挨个的进行大堆排序
     * 交换，把最大的反正后面，依次向前进行堆排序，重复此步骤
     *
     */
    public static void heapSort(int array[]) {

        for (int i = array.length / 2 - 1; i >= 0; i--) {
            maxHeap(array, i, array.length - 1);
        }

        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            maxHeap(array, 0, i - 1);
        }
    }

    //建立堆

    /*
     * 建立堆，把第一个值为父亲，找到左边的孩子
     * 孩子不能大于节点的长度
     * 如果右边的孩子存在，则挑选出中最大的孩子
     * 把最大的孩子与父亲比较，如果大则交换，并且交换两则的左边
     *
     */
    public static void maxHeap(int array[], int start, int end) {
        int father = start;
        int son = father * 2 + 1;
        while (son <= end) {
            if (son + 1 <= end && array[son] < array[son + 1]) {
                son++;
            }
            if (array[father] > array[son]) {
                return;
            } else {
                swap(array, father, son);
                father = son;
                son = father * 2 + 1;
            }
        }
    }

}
