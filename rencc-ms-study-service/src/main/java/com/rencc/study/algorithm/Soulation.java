package com.rencc.study.algorithm;

public class Soulation {
    public static int jumpFloor2(int n) {
        if (n <= 0) {
            return -1;
        } else if (n == 1) {
            return 1;
        } else {
            return 2 * jumpFloor2(n - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3,4,5};
        int target = 3;
        int mid = nums.length/2;
        while (nums[mid] <= target){
            if(nums[mid]>target){
                mid = (0+mid)/2;
            }else {
                mid = (mid + nums.length)/2;
            }
        }
        System.out.println(mid);
    }
}