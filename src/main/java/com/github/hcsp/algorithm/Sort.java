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
    for (int i = array.length - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (array[j] > array[j + 1]) {
          swap(array, j, j + 1);
        }
      }
    }
  }

  // 排序算法2
  // 按照从小到大排序
  public static void sort2(int[] array) {
    quicksort(array, 0, array.length - 1);
  }

  public static void quicksort(int[] array, int left, int right) {
    if (left < right) {
      int position = partition(array, left, right);
      quicksort(array, left, position - 1);
      quicksort(array, position + 1, right);
    }
  }

  private static int partition(int[] arr, int left, int right) {
    // 设定基准值（pivot）
    int pivot = left;
    int index = pivot + 1;
    for (int i = index; i <= right; i++) {
      if (arr[i] < arr[pivot]) {
        swap(arr, i, index);
        index++;
      }
    }
    swap(arr, pivot, index - 1);
    return index - 1;
  }


  public static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
