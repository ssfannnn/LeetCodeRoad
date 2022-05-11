package com.fannnnn.leetcode.DP;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/6
 * \*  Time: 15:12
 * \*  Description:
 * \
 */

public class 最长递增子序列 {
    /**
     * 1.dp[i]表示下标为i前的最长公共子序列
     * 2.对于每一个dp[i],位置i以前的数只要小于dp[i],那么dp[j]+1，状态转移方程为 dp[i] = Math.max(dp[i],dp[j]+1)
     *
     * */

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 1;
        for(int i = 0;i<n;++i){
            dp[i] = 1;
            for(int j = 0;j<=i;++j){
                if(nums[i] > nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }
}
