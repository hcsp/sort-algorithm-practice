package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[] {4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[] {4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array3 = new int[] {4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        bubbleSort(array1);
        System.out.println(Arrays.toString(array1));

        quickSort(array2);
        System.out.println("quick sort="+Arrays.toString(array2));

        System.out.println("merge sort origin="+ Arrays.toString(array3));
        sort2(array3);
        System.out.println("merge sort="+Arrays.toString(array3));

        int[] array_heap = new int[] {4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        System.out.println("heap sort origin="+ Arrays.toString(array_heap));
        heapSort(array_heap);
        System.out.println("heap sort="+Arrays.toString(array_heap));

        int[] array_inserted = new int[] {4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        System.out.println("insert sort origin="+ Arrays.toString(array_inserted));
        insertedSort(array_inserted);
        System.out.println("insert sort="+Arrays.toString(array_inserted));
    }

    // 排序算法1
    // 按照从小到大排序
    public static void sort1(int[] array) {
        bubbleSort(array);
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        insertedSort(array);
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
        if ( low > high ){
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

    //参考思路：https://www.bilibili.com/video/av39519566?from=search&seid=12782338700587782376
    public static void mergeSort(int[] array){
        int[] tmpArray = new int[array.length];
        mergeSort(array, tmpArray, 0, array.length-1);
    }
    public static void mergeSort(int[] array, int[] tmpArray, int low, int high){
        if (low < high){
            int mid = (high+low)/2;
            mergeSort(array, tmpArray, low, mid);
            mergeSort(array, tmpArray, mid+1, high);
            merge(array, tmpArray, low, mid, high);
        }
    }

    public static void merge(int[] array, int[] tmpArray, int low, int mid, int high){
        int tmpPos = low;
        int leftPos = low;
        int rightPos = mid+1; //右侧区间的起点坐标
        // 小的放前面，大的放后面
        while (leftPos<=mid && rightPos<=high){
            if (array[leftPos] < array[rightPos]){
                tmpArray[tmpPos++] = array[leftPos++];
            } else {
                tmpArray[tmpPos++] = array[rightPos++];
            }
        }
        //将剩余没有移动的元素填入临时数组
        while (leftPos <= mid){
            tmpArray[tmpPos++] = array[leftPos++];
        }

        //将剩余没有移动的元素填入临时数组
        while (rightPos <= high){
            tmpArray[tmpPos++] = array[rightPos++];
        }

        //将修改后的值写入原来的数组
        if (high + 1 - low >= 0){
            System.arraycopy(tmpArray, low, array, low, high + 1 - low);
        }

    }

    public static void selectionSort(int[] array){

    }

    //参考思路：https://www.bilibili.com/video/av47196993?from=search&seid=9587625421060080139
    public static void heapSort(int[] tree){
        for (int i=tree.length-1; i>=0; i--){
            build_heap(tree, tree.length-i);
            array_swap(tree, 0, i);
        }
    }

    public static void build_heap(int[] tree, int n){
        //heapify会对n及其子节点进行排序，所以从last_node开始，遍历父节点所在的堆即可，heapify会完成last_node同级节点的排序
        int last_node = n-1;
        int parent = (last_node-1)/2;

        for (int i = parent; i>=0; i--){
            heapify(tree, i, n);
        }
    }

    public static void heapify(int[] tree, int i, int n){
        if (i>=n){
            return;
        }

        int max = i;
        int left = (2*i+1);
        int right = (2*i+2);

        if ( left<n && tree[max] < tree[left] ){
            max = left;
        }
        if ( right<n && tree[max] < tree[right] ){
            max = right;
        }
        if (max != i){
            array_swap(tree, max, i);
            heapify(tree, max, n);
        }
    }

    public static void insertedSort(int[] array){
        int j;
        for (int i=1; i<array.length; i++){
            if (array[i] < array[i-1]){
                int tmp = array[i];
                for (j=i-1; j>=0 && array[j]>tmp; j--){
                    array[j+1] = array[j];
                }
                array[j+1] = tmp;
            }
        }
    }

    public static void array_swap(int[] array, int i, int j){
        int t = array[i];
        array[i]=array[j];
        array[j] = t;
    }

}
