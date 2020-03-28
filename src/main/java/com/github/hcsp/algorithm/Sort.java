package com.github.hcsp.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//import java.util.concurrent.CopyOnWriteArrayList;


public class Sort {
    public static void main(String[] args) {
//        int[] array1 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array3 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array4 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array5 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
//        sort1(array1);
//      sort2(array2);
//        sort3(array3);
//        sort4(array4);
//        sort5(array5);
//        sort6(array5);
        sort8(array5);

//        System.out.println(Arrays.toString(array1));
//        System.out.println(Arrays.toString(array2));
//        System.out.println(Arrays.toString(array3));
//        System.out.println(Arrays.toString(array4));
//        System.out.println(Arrays.toString(array5));
        System.out.println(Arrays.toString(array5));
    }

    private static void swap(int[] x, int a, int b) {
        int t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    /**
     * 基于插入的排序
     * 思想：假定当前位置元素的前面均已排序，将当前元素插入到前面的有序队列中的合适位置
     * ------------------shell排序------------>步长减至1时退化为--------->直接插入排序-----------使用二分查找优化查找插入的位置------>折半插入排序
     * <p>
     * 时间复杂度：                                                         O(N2)                                                    O(N2)
     * 空间复杂度：        O(1)                                             O(1)                                                      O(1)
     * 稳定性 ：          不稳定                                            稳定                                                      稳定
     */

    /**
     * shell排序
     *
     * @param array
     */
    public static void sort1(int[] array) {
        for (int step = array.length / 2; step >= 1; step = step / 2) {
            for (int i = step; i < array.length; i++) {
                if (array[i] < array[i - step]) {
                    int j, tmp = array[i];
                    for (j = i - step; j >= 0 && array[j] > tmp; j -= step) {
                        array[j + step] = array[j];
                    }
                    array[j + step] = tmp;
                }
            }
        }
    }

    //折半插入排序
    public static void sort2(int[] array) {
        int start, end;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                int tmp = array[i];
                start = 0;
                end = i - 1;
                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    if (array[mid] < array[i]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
                for (int j = i - 1; j >= end + 1; j--) {
                    array[j + 1] = array[j];
                }
                array[end + 1] = tmp;
            }
        }
    }


    /**
     * 基于交换的排序
     * 特点：每轮排序都会确定一个元素的最终位置，n个元素共需n-1轮排序，
     * 对于冒泡排序来说，每轮排序进行n-i次的比较，故冒泡排序的平均时间复杂度为O(N^2)，稳定
     * 对于快排来说，每轮排序都基于分治，平均情况下，每轮排序的时间为需要log(N)，故平均时间复杂度为N*log(N),平均空间复杂度为栈的深度log(N),不稳定
     */

    /**
     * 冒泡排序
     *
     * @param array
     */
    public static void sort3(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
        }

    }

    //快排
    public static void sort4(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int index = Partition(array, start, end);
            quickSort(array, start, index - 1);
            quickSort(array, index + 1, end);
        }
    }

    private static int Partition(int[] array, int start, int end) {
        int pivot = array[start];
        while (start < end) {
            while (start < end && array[end] >= pivot) {
                end--;
            }
            array[start] = array[end];
            while (start < end && array[start] <= pivot) {
                start++;
            }
            array[end] = array[start];
        }
        array[start] = pivot;
        return start;
    }


    /**
     * 基于选择的排序：
     * 思想：每趟排序从当前位置后面的n-i+1个元素中选择最小的一个，放入当前位置，直到n-i趟做完
     */

    /**
     * 简单选择
     *
     * @param array
     */
    public static void sort5(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(array, min, i);
            }
        }
    }

    //堆排序
    private static void BuildMaxHeap(int[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            AdjustDown(array, i, array.length);
        }
    }

    static void AdjustDown(int[] array, int k, int len) {
        int tmp = array[k];
        for (int i = 2 * k; i < len; i *= 2) {
            if (i < len - 1 && array[i] < array[i + 1]) {
                i++;
            }
            if (tmp >= array[i]) {
                break;
            } else {
                array[k] = array[i];
                k = i;
            }
        }
        array[k] = tmp;
    }

    public static void sort6(int[] array) {
        BuildMaxHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            AdjustDown(array, 0, i - 1);
        }
    }

    /**
     * 归并排序
     * 归并排序基于分治
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(N)
     * 稳定性：稳定
     *
     * @param array
     */
    public static void sort7(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            Merge(array, start, mid, end);
        }
    }

    private static void Merge(int[] array, int start, int mid, int end) {
        int[] B = array.clone();
        int i, k, j;
        for (i = start, j = mid + 1, k = i; i <= mid && j <= end; k++) {
            if (B[i] <= B[j]) {
                array[k] = B[i++];
            } else {
                array[k] = B[j++];
            }
        }
        while (i <= mid) {
            array[k++] = B[i++];
        }
        while (j <= end) {
            array[k++] = B[j++];
        }
    }


    /**
     * 睡眠排序之只要我睡得足够久，没有我等不到的结果;如果还不行，那么再睡一万年...
     *
     * @param array
     */
    static List<Integer> list = new ArrayList<>();
    static List<Integer> listSyn = Collections.synchronizedList(list);
    //读多写少的时候，可以用写时复制，用它也试了试
//    static List<Integer> listSyn = new CopyOnWriteArrayList<>();

    public static void sort8(int[] array) {
        sleepSort(array);
        try {
            //为了等待最终的结果而陷入沉睡，沉睡时间务必要大于数组中最大值
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final int[] i = {-1};
        listSyn.forEach((e) -> array[++i[0]] = e);
    }

    static void sleepSort(int[] arr) {

        class Sleep extends Thread {

            private int time;

            Sleep(int time) {
                this.time = time;
            }

            public void run() {
                try {
                    //为了避免出现负数，加一个小小的偏移
                    Thread.sleep((time + 100) * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                listSyn.add(time);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            new Sleep(arr[i]).start();
        }
    }
}

