package com.rencc.study.algorithm;


/**
 * 归并排序
 * 1. 定义临时数组tmp
 * 2. 从“中间”分两段拆分到不可再拆
 * 3. 两段并行循环，比对，谁小，谁进tmp且循环自增
 * 4. 处理两段剩余部分进tmp
 * 5. 循环tmp，处理原数组，起始点加tmp循环指针
 * @author renchaochao
 * @date 2020/12/22 18:04
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 4, 1, 8, 2, 9, 0, 5, 6};
        //新建一个临时数组存放
        int[] tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, tmp);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void mergeSort(int[] arr, int low, int high, int[] tmp) {
        //拆分终止条件
        if (low < high) {
            int mid = (low + high) / 2;
            //对左边序列进行归并排序
            mergeSort(arr, low, mid, tmp);
            //对右边序列进行归并排序
            mergeSort(arr, mid + 1, high, tmp);
            //合并两个有序序列
            merge(arr, low, mid, high, tmp);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high, int[] tmp) {
        int i = 0;
        //左边序列和右边序列起始索引
        int j = low, k = mid + 1;
        int n = 0;
        while (j <= mid && k <= high) {
            if (arr[j] < arr[k]) {
                tmp[i++] = arr[j++];
            } else {
                tmp[i++] = arr[k++];
                if(arr[j] == arr[k]){
                    j++;
                    n++;
                }
            }
        }
        //若左边序列还有剩余，则将其全部拷贝进tmp[]中
        while (j <= mid) {
            tmp[i++] = arr[j++];
        }
        //若右边序列还有剩余，则将其全部拷贝进tmp[]中
        while (k <= high) {
            tmp[i++] = arr[k++];
        }

        for (int t = 0; t < i; t++) {
            arr[low + t] = tmp[t];
        }
    }
}