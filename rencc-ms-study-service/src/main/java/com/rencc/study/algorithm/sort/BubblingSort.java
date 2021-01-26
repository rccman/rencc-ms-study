package com.rencc.study.algorithm.sort;

import java.util.Arrays;

/**
 * @Description: 冒泡排序
 * 内层两两交换，外层每轮循环找到当前最大的放到尾部，尾部固定不再变化，不再参与循环和比对
 * @Author: renchaochao
 * @Date: 2021/1/26 9:18
 **/
public class BubblingSort {

    public static void main(String[] args) {
        int[] array = {2,6,8,3,9,2,1,7,5,0};
        solution(array);
        System.out.println(Arrays.toString(array));
    }

    private static void solution(int[] array) {
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j+1]<array[j]){
                    int tmp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=tmp;
                }
            }
        }
    }
}
