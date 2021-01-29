package com.rencc.study.algorithm.sort;

import java.util.Arrays;

/**
 * @Description: 选择排序
 * 外层循环，记录最小值坐标，内层循环找最小值坐标，每次找到最小的，放到头部，头部不再参与循环
 * @Author: renchaochao
 * @Date: 2021/1/26 9:30
 **/
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {2, 6, 8, 3, 9, 2, 1, 7, 5, 0};
        solution(array);
        System.out.println(Arrays.toString(array));
    }

    private static void solution(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = tmp;
            }
        }
    }
}
