package com.rencc.study.algorithm;

import java.util.Arrays;

/**
 * @Description: 快速排序
 * @Author: renchaochao
 * @Date: 2021/1/18 22:41
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 4, 1, 8, 2, 9, 0, 5, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = getMidIndex(arr,start,end);
            quickSort(arr,start,mid);
            quickSort(arr,mid+1,end);
        }

    }

    private static int getMidIndex(int[] arr, int start, int end) {
        int tmp = arr[start];
        while (start < end){
            //从后往前找，小于tmp的，换到start位置
            while (start < end && arr[end] >= tmp){
                end--;
            }
            arr[start] = arr[end];
            //从前往后找，大于tmp的，换到end位置
            while (start < end && arr[start] <= tmp ){
                start++;
            }
            arr[end] = arr[start];
        }
        //当start = end后，即使中心位置，也是tmp应该在的位置
        arr[start] = tmp;
        return start;
    }
}
