package com.fannnnn.leetcode.question1480;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/28
 * \*  Time: 8:22
 * \*  Description:
 * \
 */

public class Solution {


    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1;i<n;++i){
            dp[i] = dp[i-1] + nums[i];
        }
        return dp;
    }
}
