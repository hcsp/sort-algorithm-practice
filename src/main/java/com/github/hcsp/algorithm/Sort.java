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

    private static void exch(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 排序算法1
    // 按照从小到大排序
    public static void sort1(int[] array) {
        //冒泡排序
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    exch(array, j, j + 1);
                }
            }
        }
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        //选择排序
        for (int i = 0; i < array.length - 1; i++) {
            int temp = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[temp]) {
                    exch(array, j, temp);
                }
            }
        }
    }

    //插入排序
    public static void sort3(int[] array) {
        for (int i = 1; i < array.length; i++) {
            //将第i个数插入前面排序好的子数组中
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    exch(array, j, j - 1);
                }
            }
        }
    }

    //快速排序
    public static void sort4(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pi = partition(array, left, right);
            quickSort(array, left, pi);
            quickSort(array, pi + 1, right);
        }
    }


    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int lo = left - 1;
        int hi = right;
        while (true) {
            //从右往左
            while (array[--hi] > pivot) {
                if (hi == left) {
                    break;
                }
            }
            //从左往右找
            while (array[++lo] < pivot) {
                if (lo == right) {
                    break;
                }
            }
            if (lo >= hi) {
                break;
            }
            //交换数据
            exch(array, lo, hi);
        }
        exch(array, lo, right);
        //应该返回hi
        return hi;
    }

    //归并排序
    public static void sort5(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            mergeSort(array, lo, mid);
            mergeSort(array, mid + 1, hi);
            merge(array, lo, mid, hi);
        }

    }

    private static void merge(int[] array, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        int[] aux = new int[hi + 1];
        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                array[k] = aux[j++];
            } else if (j > hi) {
                array[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
        }
    }

    //堆排序
    public static void sort6(int[] array) {

        BinaryHeap heap = new BinaryHeap(array.length);
        for (int i : array) {
            heap.insert(i);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = heap.delMin();
        }
    }

    //二叉堆
    public static class BinaryHeap {
        private int[] pq;
        private int N = 0;

        public BinaryHeap(int cap) {
            pq = new int[cap + 1];
        }

        public int min() {
            return pq[1];
        }

        public int delMin() {
            int val = min();
            exch(pq, 1, N);
            pq[N] = Integer.MAX_VALUE;
            N--;
            sink(1);
            return val;
        }

        public void insert(int val) {
            N++;
            pq[N] = val;
            swim(N);

        }

        void sink(int key) {
            while (left(key) <= N) {
                int older = left(key);
                if (right(key) <= N && less(pq, right(key), older)) {
                    older = right(key);
                }
                if (less(pq, key, older)) {
                    break;
                }
                exch(pq, key, older);
                key = older;
            }
        }

        void swim(int key) {
            while (parent(key) >= 1 && less(pq, key, parent(key))) {
                exch(pq, key, parent(key));
                key = parent(key);
            }
        }

        boolean less(int[] array, int i, int j) {
            return array[i] < array[j];
        }

        int parent(int root) {
            return root / 2;
        }

        int left(int root) {
            return root * 2;
        }

        int right(int root) {
            return root * 2 + 1;
        }
    }

}
