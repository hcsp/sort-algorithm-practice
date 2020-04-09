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

    // 排序算法1 冒泡
    // 按照从小到大排序
    public static void sort1(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                }

            }
        }

    }

    // 排序算法2  快速排序
    // 按照从小到大排序 参考https://segmentfault.com/a/1190000013888583
    public static void sort2(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int L, int R) {

        int i = L;
        int j = R;

        //支点
        int pivot = array[(L + R) / 2];

        //左右两端进行扫描，只要两端还没有交替，就一直扫描
        while (i <= j) {

            //寻找直到比支点大的数
            while (pivot > array[i]) {
                i++;
            }
            //寻找直到比支点小的数
            while (pivot < array[j]) {
                j--;
            }

            //此时已经分别找到了比支点小的数(右边)、比支点大的数(左边)，它们进行交换
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        //上面一个while保证了第一趟排序支点的左边比支点小，支点的右边比支点大了。


        //“左边”再做排序，直到左边剩下一个数(递归出口)
        if (L < j) {
            quickSort(array, L, j);
        }

        //“右边”再做排序，直到右边剩下一个数(递归出口)
        if (i < R) {
            quickSort(array, i, R);
        }
    }


    //第三种 归并排序
    //思想：将两个已排好序的数组合并成一个有序的数组,称之为归并排序
    //步骤：遍历两个数组，比较它们的值。谁比较小，谁先放入大数组中，直到数组遍历完成
    public static void sort3(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int L, int R) {
        if (L == R) {
            return;
        } else {
            //取中间的数进行划分
            int M = (L + R) / 2;

            //左边的数不断进行拆分；
            mergeSort(array, L, M);
            //右边的数不断进行拆分；
            mergeSort(array, M + 1, R);

            //合并
            merage(array, L, M + 1, R);


        }
    }


    //合并数组
    private static void merage(int[] array, int L, int M, int R) {
        //左边数组的大小
        int[] leftArray = new int[M - L];
        int[] rightArray = new int[R - M + 1];

        //往这两个数组填充数据
        for (int i = L; i < M; i++) {
            leftArray[i - L] = array[i];
        }

        for (int i = M; i <= R; i++) {
            rightArray[i - M] = rightArray[i];
        }


        int i = 0, j = 0;
        int k = L;

        //比较这两个数组的值，哪个小，就往数组上放
        while (i < leftArray.length && j < rightArray.length) {
            //谁比较小，谁将方放入到大数组中，移动指针，继续比较下一个

            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
                k++;
            } else {
                array[k] = rightArray[j];
                j++;
                k++;
            }
        }

        //如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数抄到大数组中(剩下的都是大数字)
        while (i < leftArray.length) {
            array[k] = leftArray[i];

            i++;
            k++;
        }
        //如果右边的数组还没比较完，左边的数都已经完了，那么将右边的数抄到大数组中(剩下的都是大数字)
        while (j < rightArray.length) {
            array[k] = rightArray[j];

            k++;
            j++;


        }
    }


    //第四种 插入排序
    //直接插入排序：采用顺序查找法查找插入位置，假如第i个元素是需要排序的，那么i-1之前的都是有顺序的
    //第一：复制插入元素 x=a[i] 先将第i个元素的值存放到临时变量
    //第二：和已经排好顺序的最后一个元素比较大小，假设是a[j]的值 那么a[j]的初始值为a[i-1]
    //如果a[j]比a[i]大，则将a[j]往后移，即a[j+1]=a[j],则移动完成
    public static void sort4(int[] array) {
        if (array == null) {
            throw new RuntimeException("array is null");
        }

        int length = array.length;
        if (length > 0) {
            for (int i = 1; i < length; i++) {
                int temp = array[i];
                int j = i;
                for (; j > 0 && array[j] > temp; j--) {
                    array[j + 1] = array[j];
                }
                array[j] = temp;

            }
        }
    }

    //第五种：堆排序（不稳定；不是很快也不是很慢；不适用于待排序个数较小的，当待排序数较多时推荐使用）
    //定义：将堆顶元素反复排序反复输出
    //堆排序：对一个无序序列建堆，然后输出根；重复该过程，就可以由一个无序序列输出有序序列了

    //如何在输出堆顶元素之后，调整剩余元素为一个新的堆？（小根堆）
    //1。输出堆顶元素之后，以堆中最后一个元素替代之
    //2。然后将根节点值与左右子树的根节点值进行比较，并与其中小者进行交换
    //3。重复上述操作，直至叶子结点，将得到新的堆，称这个从堆顶至叶子的调整过程为"筛选"

    //对1到n进行堆排序；建初始堆；进行n-1躺排序；根与最后一个元素交换；对1到i-1重新建堆
    //如何从一个无序的队列变成小根堆？
    //单结点的二叉树是堆；在完全二叉树中，所有以叶子结点（序号i>n/2）为根的子树都是堆。所以，我们从完全二叉中最后一个非叶子结点开始调整
    //从最后一个非叶子结点（n/2）开始，以此向前调整：
    //1。调整从第n/2个元素开始，将以该元素为根的二叉树调整为堆
    //2。将以序号为n/2-1的结点为根的二叉树调整为堆(查看左右结点哪个教小，则何其交换位置)
    //3。再将以序号为n/2-2结点为根的二叉树调整为堆；

    public static void sort5(int[] array) {
        int n = array.length;

        //初始化堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        //排序
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int l = 2 * i + 1; //左结点
        int r = 2 * i + 2; //右结点

        //left>root
        if (l < n && array[l] > array[largest]) {
            largest = l;
        }

        //right>root
        if (r < n && array[r] > array[largest]) {
            largest = r;
        }

        //如果最大值不是根节点，调整
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            //heapify
            heapify(array, n, largest);
        }
    }


}

