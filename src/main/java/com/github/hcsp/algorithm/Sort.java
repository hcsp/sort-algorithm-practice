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
    int length = array.length;
    if (length == 1) {
      return;
    }
    for (int i = 1; i < length; i++) {
      int j = i;
      while (j >= 1 && (array[j - 1] > array[j])) {
        exchange(j, j - 1, array);
        j--;
      }
    }
  }

  // 排序算法2
  // 按照从小到大排序
  public static void sort2(int[] array) {
    quickSortInner(array, 0, array.length - 1);
  }

  private static void quickSortInner(int[] array, int lo, int hi) {
    if (hi - lo < 1) {
      return;
    }
    int j = partition(array, lo, hi);
    quickSortInner(array, lo, j);
    quickSortInner(array, j + 1, hi);
  }

  private static int partition(int[] array, int lo, int hi) {
    int pivot = lo;

    int i = lo + 1;
    int j = hi;

    while (true) {
      while (array[i] <= array[pivot] && i <= hi - 1) {
        i++;
      }

      while (array[j] >= array[pivot] && j > lo) {
        j--;
      }

      if (j <= i) {
        break;
      }
      exchange(i, j, array);
    }

    exchange(pivot, j, array);
    return j;
  }

  public static void exchange(int index1, int index2, int[] arr) {
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }
}

