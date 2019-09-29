package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[] {4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[] {4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        selectSort(array1);
        bubbleSort(array2);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    // 排序算法1
    // 按照从小到大排序
    public static void selectSort(int[] array) {
    	for(int x=0;x<array.length-1;x++)
    	{
    		for(int y=x+1;y<array.length;y++)
    		{
    			if(array[x]>array[y])
    			{
    				int temp = array[x];
    				array[x] = array[y];
    				array[y] = temp;
    			}
    		}
    	}
    }

    // 排序算法2
    // 按照从小到大排序
    public static void bubbleSort(int[] array) {
    	for(int x=0;x<array.length-1;x++)
    	{
    		for(int y=0;y<array.length-x-1;y++)
    		{
    			if(array[y]>array[y+1])
    			{
    				int temp = array[y];
    				array[y] = array[y+1];
    				array[y+1] = temp;
    			}
    		}
    	}