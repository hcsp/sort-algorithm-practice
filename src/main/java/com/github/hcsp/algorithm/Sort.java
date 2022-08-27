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

    // 排序算法1
    // 按照从小到大排序
    //bubbleSort
    public static void sort1(int[] array) {
        //时间复杂度O(n^2)
        bubbleSort(array);
    }

    public static void sort2(int[] array) {
        //平均时间复杂度O(nlogn),最坏O(n^2)
        quickSort(array, 0, array.length - 1);
    }

    public static void sort3(int[] array) {
        //时间复杂度O(nlogn)
        mergeSort(array, 0, array.length - 1);
    }

    public static void sort4(int[] array) {
        //平均时间复杂度O(n^2)
        insertSort(array);
    }

    public static void sort5(int[] array) {
        //平均时间复杂度O(n^2)
        selectionSort(array);
    }

    public static void sort6(int[] array) {
        //时间复杂度O(nlogn)
        heapSort(array);
    }

    private static void heapSort(int[] array) {
        /*
         *  第一步：将数组堆化
         *  beginIndex = 第一个非叶子节点。
         *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
         *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
         */
        int len = array.length - 1; //len为未排序的堆（数组）的长度
        //从（n/2 - 1）-> 0遍历。获得一个最大二叉堆
        int beginIndex = (array.length >> 1) - 1;
        for (int i = beginIndex; i >= 0; i--) {//遍历所有的非叶子节点
            maxHeapDown(array, i, len);
        }
        /*
         * 第二步：对堆化数据排序
         * 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
         * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。
         * 直至未排序的堆长度为 0。
         */
        for (int i = len; i > 0; i--) {
            swap(array, i, 0);
            //只有切换到第一个的元素不符合最大堆，其余元素符合最大堆，所以只要从第一个开始就行了。len为未排序长度，最大的已经去掉了，
            //所以在之前的基础上再减1
            maxHeapDown(array, 0, i - 1);
        }
    }

    private static void maxHeapDown(int[] array, int index, int len) {
        int leftChildIndex = (index << 1) + 1; //当前节点的左子节点
        int rightChild = leftChildIndex + 1; //当前节点的右子节点
        int maxIndex = leftChildIndex; //最大值默认左子节点
        if (leftChildIndex > len) { //左子节点超出范围，直接返回
            return;
        }
        if (rightChild <= len && array[leftChildIndex] < array[rightChild]) {//判断左右子节点，看看哪个大
            maxIndex = rightChild;
        }
        if (array[index] < array[maxIndex]) {
            swap(array, index, maxIndex); //父节点和最大的子节点调换，继续判断交换后的父节点是否符合堆
            maxHeapDown(array, maxIndex, len); //此时maxIndex已经换到父节点上
        }
    }

    private static void selectionSort(int[] array) {
        int minIndex;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;
            //找出未排序元素中最小元素的下标
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            //最小元素下标和i不同，那么交换位置。
            if (minIndex != i) {
                swap(array, i, minIndex);
            }
        }
    }

    private static void insertSort(int[] array) {
        //默认第一个不需要排序，从第二个开始
        for (int i = 1; i < array.length; i++) {
            //j是从i的前面一个开始，一直向前
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > array[i]) { //array[i] < array[j]就是大的在前面，小的在后面
                    swap(array, i, j); //交换位置
                    i -= 1; //同时i的索引也要向前，指向交换后所在的位置
                } else {
                    break;
                }
            }

        }
    }

    private static void mergeSort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            //中间索引
            int midIndex = (lowIndex + highIndex) >> 1;
            //左边递归
            mergeSort(array, lowIndex, midIndex);
            //右边递归
            mergeSort(array, midIndex + 1, highIndex);
            //合并
            merge(array, lowIndex, midIndex, highIndex);
        }
    }

    private static void merge(int[] array, int lowIndex, int midIndex, int highIndex) {
        int[] temp = new int[highIndex - lowIndex + 1]; //临时数据
        int tempIndex = 0; //临时数据索引
        int leftIndex = lowIndex; //左边数据的索引
        int rightIndex = midIndex + 1; //右边数组的索引

        //将左右数组的元素按照顺序放到临时数组中
        //结束的条件是左边或者右边数组的索引超过了它们所在左右数组的长度
        //比较左右数组元素，哪个小就把它放到临时数组中，然后数组的索引和临时数组的索引都+1
        while (leftIndex <= midIndex && rightIndex <= highIndex) {
            if (array[leftIndex] <= array[rightIndex]) {
                temp[tempIndex++] = array[leftIndex++];
            } else {
                temp[tempIndex++] = array[rightIndex++];
            }
        }
        //如果右数组已经已经全部放到临时数据中，而左数组还没
        while (leftIndex <= midIndex) {
            temp[tempIndex++] = array[leftIndex++];
        }
        //如果左数组已经已经全部放到临时数据中，而右数组还没
        while (rightIndex <= highIndex) {
            temp[tempIndex++] = array[rightIndex++];
        }

        //将临时数组中的数据放到原数组中
        for (int i = 0; i < temp.length; i++) {
            array[lowIndex + i] = temp[i];
        }
    }

    private static void quickSort(int[] array, int lowIndex, int highIndex) {
        //如果排序的数组只有一个元素或者没有元素，传入的lowIndex>=highIndex
        if (lowIndex < highIndex) {
            int pivotIndex = partition(array, lowIndex, highIndex);
            //pivotIndex减一加一是因为pivotIndex这个位置已经定了。
            quickSort(array, lowIndex, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, highIndex);
        }
    }

    private static void bubbleSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            boolean Flag = false; //是否发生交换，如果没有表示已经排好序
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    Flag = true;
                }
            }
            if (!Flag) {
                break;
            }
        }
    }

    //选取最后一个元素为中间元素
    private static int partition(int[] array, int lowIndex, int highIndex) {
        int pivot = array[highIndex];
        int pivotIndex = lowIndex;
        for (int i = lowIndex; i < highIndex; i++) {
            if (array[i] < pivot) {
                swap(array, pivotIndex, i);
                pivotIndex += 1;
            }
        }
        swap(array, highIndex, pivotIndex);
        return pivotIndex;
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp;
        temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
