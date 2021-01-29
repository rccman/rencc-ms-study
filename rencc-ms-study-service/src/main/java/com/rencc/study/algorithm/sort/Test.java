package com.rencc.study.algorithm.sort;

import java.util.Arrays;

/**
 * @Description:
 * @Author: renchaochao
 * @Date: 2021/1/27 18:57
 **/
public class Test {
    public static void main(String[] args) {
        int[] arr = {9, 8, 5, 3, 2, 6, 7, 2, 1, 0};
        //冒泡排序
//        solutionMP(arr);
        //选择排序
//        solutionXZ(arr);
        //插入排序
//        solutionCR(arr);
        //希尔排序
//        solutionXE(arr);
        //归并排序
//        solutionGB(arr);
        //快速排序
        solutionKS(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void solutionKS(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int midIndex = getMidIndex(arr, start, end);
            quickSort(arr, start, midIndex);
            quickSort(arr, midIndex + 1, end);
        }
    }

    private static int getMidIndex(int[] arr, int start, int end) {
        int tmp = arr[start];
        while (start < end) {
            //从后往前找，小于tmp的，换到start位置
            while (start < end && arr[end] >= tmp) {
                end--;
            }
            arr[start] = arr[end];
            //从前往后找，大于tmp的，换到end位置
            while (start < end && arr[start] <= tmp) {
                start++;
            }
            arr[end] = arr[start];
        }
        //当start = end后，即使中心位置，也是tmp应该在的位置
        arr[start] = tmp;
        return start;
    }

    private static void solutionGB(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, tmp);
    }

    private static void mergeSort(int[] arr, int start, int end, int[] tmp) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid, tmp);
            mergeSort(arr, mid + 1, end, tmp);
            sort(arr, start, mid, end, tmp);
        }
    }

    private static void sort(int[] arr, int start, int mid, int end, int[] tmp) {
        int i = 0;
        int j = start;
        int k = mid + 1;
        while (j <= mid && k <= end) {
            if (arr[j] < arr[k]) {
                tmp[i++] = arr[j++];
            } else {
                tmp[i++] = arr[k++];
            }
        }
        while (j <= mid) {
            tmp[i++] = arr[j++];
        }
        while (k <= end) {
            tmp[i++] = arr[k++];
        }
        for (int t = 0; t < i; t++) {
            arr[t + start] = tmp[t];
        }
    }

    private static void solutionXE(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            int tmp;
            for (int i = gap; i < arr.length; i++) {
                int preIndex = i - gap;
                tmp = arr[i];
                while (preIndex >= 0 && tmp < arr[preIndex]) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = tmp;
            }

            gap = gap / 2;
        }
    }

    private static void solutionCR(int[] arr) {
        int tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            int preIndex = i;
            tmp = arr[preIndex + 1];
            while (preIndex >= 0 && tmp < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = tmp;
        }
    }

    private static void solutionXZ(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tmpIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[tmpIndex] > arr[j]) {
                    tmpIndex = j;
                }
            }
            if (tmpIndex > i) {
                swap(arr, tmpIndex, i);
            }
        }
    }

    private static void solutionMP(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
