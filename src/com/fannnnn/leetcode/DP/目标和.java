package com.fannnnn.leetcode.DP;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/17
 * \*  Time: 15:27
 * \*  Description:
 * \
 */

public class 目标和 {

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }
        if(Math.abs(target) > Math.abs(sum)) return 0;
        int t = sum*2+1;
        int[][] dp = new int[n][t];
        if(nums[0]==0){
            dp[0][sum] =  2;
        }else {
            dp[0][sum-nums[0]] = 1;
            dp[0][sum+nums[0]] = 1;
        }
        for(int i = 1;i<n;++i){
            for(int j = 0;j<t;++j){
                int l = (j-nums[i])>=0 ? j-nums[i] : 0;
                int r = (j + nums[i]) < t ? j+nums[i] : 0;
                dp[i][j] = dp[i-1][l] + dp[i-1][r];
            }
        }
        return dp[n-1][sum+target];
    }
}
