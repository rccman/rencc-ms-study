package com.rencc.study.algorithm.sort;

import java.util.Arrays;

/**
 * @Description: 希尔排序
 * @Author: renchaochao
 * @Date: 2021/1/26 10:27
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] array = {2, 6, 8, 3, 9, 2, 1, 7, 5, 0};
        solution(array);
        System.out.println(Arrays.toString(array));
    }

    private static void solution(int[] array) {
        int tmp;
        int gap = array.length/2;
        while (gap>0){
            for (int i = gap; i < array.length; i++) {
                tmp = array[i];
                int tmpIndex = i-gap;
                while (tmpIndex>=0 && tmp < array[tmpIndex]){
                    array[tmpIndex+gap] = array[tmpIndex];
                    tmpIndex-=gap;
                }
                if(tmpIndex<=i){
                    array[tmpIndex+gap] = tmp;
                }
            }
            gap=gap/2;
        }

    }
}
