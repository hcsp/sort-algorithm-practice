package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[] {4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[] {4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        bubbleSort(array1);
        System.out.println(Arrays.toString(array1));

        quickSort(array2);
        System.out.println("quick sort="+Arrays.toString(array2));
    }

    // 排序算法1
    // 按照从小到大排序
    public static void sort1(int[] array) {
        bubbleSort(array);
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        quickSort(array);
    }

    public static void bubbleSort(int[] array){
        for (int i=0; i< array.length; i++){
            for (int j=i+1; j<array.length; j++){
                int a = array[i];
                int b = array[j];
                int t = 0;
                if (a>b){
                    t = array[i];
                    array[i] = array[j];
                    array[j] = t;
                }
            }
        }
    }

    public static void quickSort(int[] array){
        /*
        1、先从数列中取出一个数作为基准数

        2、分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边

        3、再对左右区间重复第二步，直到各区间只有一个数
        * */
        quickSort(array, 0, array.length-1);
    }

    //思路参考：https://www.bilibili.com/video/av39519566?from=search&seid=12782338700587782376
    public static void quickSort(int[] array, int low, int high){
        if ( low>high){
            return;
        }

        int i = low;
        int j = high;
        int value = array[low]; //拿第一个节点试试
        while ( i<j ){
            //往左移动
            while (value<=array[j] && i<j){
                j--;
            }
            //往右移动
            while (value>=array[i] && i<j){
                i++;

            }
            // 交换2者的值，如果i和j相遇，则循环不再进行
            array_swap(array, i, j);
        }

        //交换初始值和最终位置的值
        array_swap(array, low, i);
        //分区间进行快排
        quickSort(array, low, i-1);
        quickSort(array, i+1, high);


    }

    public static void array_swap(int[] array, int i, int j){
        int t = array[i];
        array[i]=array[j];
        array[j] = t;
    }

}
