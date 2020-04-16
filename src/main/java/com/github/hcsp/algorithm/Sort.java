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
        sort1(array3);
        sort2(array4);
        sort2(array5);
        sort2(array6);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));
        System.out.println(Arrays.toString(array5));
        System.out.println(Arrays.toString(array6));
    }

    // 排序算法1
    // 冒泡排序
    // 按照从小到大排序
    public static void sort1(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.println(array[i]);
        }
    }

    // 排序算法2
    // 快速排序
    // 按照从小到大排序
    public static void sort2(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int low, int high) {
        int p, i, j, temp;

        if (low >= high) {
            return;
        }
        //p就是基准数,这里就是每个数组的第一个
        p = array[low];
        i = low;
        j = high;
        while (i < j) {
            //右边当发现小于p的值时停止循环
            while (array[j] >= p && i < j) {
                j--;
            }

            //这里一定是右边开始，上下这两个循环不能调换（下面有解析，可以先想想）

            //左边当发现大于p的值时停止循环
            while (array[i] <= p && i < j) {
                i++;
            }

            temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }
        array[low] = array[i]; //这里的arr[i]一定是停小于p的，经过i、j交换后i处的值一定是小于p的(j先走)
        array[i] = p;
        quickSort(array, low, j - 1);  //对左边快排
        quickSort(array, j + 1, high); //对右边快排

    }

    // 排序算法3
    // 归并排序
    // 按照从小到大排序
    public void sort3(int[] array) {
        int[] orderedArr = new int[array.length];
        for (int i = 2; i < array.length * 2; i *= 2) {
            for (int j = 0; j < (array.length + i - 1) / i; j++) {
                int left = i * j;
                int mid = left + i / 2 >= array.length ? (array.length - 1) : (left + i / 2);
                int right = i * (j + 1) - 1 >= array.length ? (array.length - 1) : (i * (j + 1) - 1);
                int start = left, l = left, m = mid;
                while (l < mid && m <= right) {
                    if (array[l] < array[m]) {
                        orderedArr[start++] = array[l++];
                    } else {
                        orderedArr[start++] = array[m++];
                    }
                }
                while (l < mid) {
                    orderedArr[start++] = array[l++];
                }
                while (m <= right) {
                    orderedArr[start++] = array[m++];
                }
                System.arraycopy(orderedArr, left, array, left, right - left + 1);
            }
        }
    }

    // 排序算法4
    // 插入排序
    // 按照从小到大排序
    public void sort4(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // 排序算法5
    // 选择排序
    // 按照从小到大排序
    public void sort5(int[] array) {
        int N = array.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(array[j], array[min])) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

    private static boolean less(int v, int w) {
        return v - w < 0;
    }

    // 排序算法6
    // 堆排序
    // 按照从小到大排序
    public void sort6(int[] array) {
        /*
         *  第一步：将数组堆化
         *  beginIndex = 第一个非叶子节点。
         *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
         *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
         */
        int len = array.length - 1;
        int beginIndex = (array.length >> 1) - 1;
        for (int i = beginIndex; i >= 0; i--) {
            minHeapify(array, i, len);
        }
        /*
         * 第二步：对堆化数据排序
         * 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
         * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。
         * 直至未排序的堆长度为 0。
         */
        for (int i = len; i > 0; i--) {
            swap(array, 0, i);
            minHeapify(array, 0, i - 1);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     *
     * @param index 需要堆化处理的数据的索引
     * @param len   未排序的堆（数组）的长度
     */
    private void minHeapify(int[] array, int index, int len) {
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1;           // 右子节点索引
        int cMax = li;             // 子节点值最大索引，默认左子节点。
        if (li > len) {
            return;
        }      // 左子节点索引超出计算范围，直接返回。
        if (ri <= len && array[ri] > array[li]) { // 先判断左右子节点，哪个较大。
            cMax = ri;
        }
        if (array[cMax] > array[index]) {
            swap(array, cMax, index);      // 如果父节点被子节点调换，
            minHeapify(array, cMax, len);  // 则需要继续判断换下后的父节点是否符合堆的特性。
        }
    }
}
