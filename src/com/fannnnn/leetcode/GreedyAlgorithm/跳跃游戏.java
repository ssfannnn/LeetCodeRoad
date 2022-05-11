package com.fannnnn.leetcode.GreedyAlgorithm;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/6
 * \*  Time: 9:03
 * \*  Description:
 * \
 */

public class 跳跃游戏 {

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i = 0;i<n;++i){
            if(i <= max){
                max = Math.max(max,i+nums[i]);
                if(max >= n-1) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};
        System.out.println(canJump(arr));
    }
}
