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
        //冒泡排序
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    exch(array, j, j + 1);
                }
            }
        }
    }

    private static void exch(int[] array, int i, int j) {
        int tem = array[i];
        array[i] = array[j];
        array[j] = tem;
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        //插入排序
        int length = array.length;
        //从第二个开始,插入之前的队列中去
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > array[i]) {
                    exch(array, i, j);
                }
            }
        }
    }

    //快速排序
    public static void sort3(int[] array) {
        int length = array.length;
        quickSort(array, 0, length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pi = partition(array, left, right);
            quickSort(array, left, pi);
            quickSort(array, pi + 1, right);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int left = low;
        int right = high - 1;
        //从左侧开始查找
        for (; left <= right; left++) {
            if (array[left] > pivot) {
                //从右侧开始查找
                for (right = high - 1; right > left; right--) {
                    if (array[right] < pivot) {
                        exch(array, left, right);
                        break;
                    }
                }
                //左右相遇后,交换位置
                if (left == right) {
                    exch(array, left, high);
                }
            }
        }
        return left - 1;
    }

    //归并排序
    public static void sort4(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    public static void mergeSort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(array, lo, mid);
        mergeSort(array, mid + 1, hi);
        merge(array, lo, mid, hi);
    }


    public static void merge(int[] array, int lo, int mid, int hi) {

        int i = lo, j = mid + 1;
        int[] aux = new int[hi + 1];
        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }
        //
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


    //选择排序
    public static void sort5(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (array[min] > array[j]) {
                    exch(array, min, j);
                }
            }
        }
    }

    //堆排序
    public static void sort6(int[] array) {
        BinaryHeap binaryHeap = new BinaryHeap(array.length);
        for (int i : array) {
            binaryHeap.insert(i);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = binaryHeap.delMin();
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

        public void insert(int val) {
            N++;
            pq[N] = val;
            swim(N);
        }

        public int delMin() {
            int val = min();
            exch(pq, 1, N);
            pq[N] = Integer.MAX_VALUE;
            N--;
            sink(1);
            return val;
        }

        public void sink(int key) {
            while (left(key) <= N) {
                int older = left(key);
                if (right(key) <= N && less(pq, right(key), older)) {
                    older = right(key);
                }
                //节点比左右都小,不下沉
                if (less(pq, key, older)) {
                    break;
                }
                exch(pq, key, older);
                key = older;
            }
        }

        public void swim(int key) {
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
