package com.fannnnn.review.question198;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/24
 * \*  Time: 15:15
 * \*  Description:
 * \
 */

public class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<n;++i){
            for(int j = i-2;j>=0;--j){
                dp[i] = Math.max(dp[i],dp[j]+nums[i]);
            }
        }
        return Math.max(dp[n-1],dp[n-2]);
    }
}
