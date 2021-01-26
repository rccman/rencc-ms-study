package com.rencc.study.algorithm.sort;

import java.util.Arrays;

/**
 * @Description: 插入排序
 * ![](https://img-1257435715.cos.ap-beijing.myqcloud.com/20210126095354.png)
 * 外层循环拿出前一位，内层循环比对是否小于上一位，小于，内层循环里移动前一位到当前位置。内层循环结束就是本次内层循环拿出的当前元素所在位置
 * @Author: renchaochao
 * @Date: 2021/1/26 9:41
 **/
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {2, 6, 8, 3, 9, 2, 1, 7, 5, 0};
        solution(array);
        System.out.println(Arrays.toString(array));
    }

    private static void solution(int[] array) {
        int tmp;
        for (int i = 0; i < array.length-1; i++) {
            tmp = array[i+1];
            int preIndex = i;
            while (preIndex >= 0 && tmp < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex+1] = tmp;
        }
    }
}
