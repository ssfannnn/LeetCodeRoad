package com.fannnnn.review.question53;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/21
 * \*  Time: 16:17
 * \*  Description:
 * \
 */

public class Solution {

    /**
     * 动态规划 dp[i]表示前i个数的最大子数组之和
     * 如果nums[i] > 前i-1个数字的最大和，那么此时的最大和应该是nums[i]
     * 状态转移方程为 dp[i] = Math.max(nums[i],dp[0]+nums[i])
     * **/

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1;i<n;++i){
            dp[i] = Math.max(nums[i],dp[0]+nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
