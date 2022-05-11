package com.fannnnn.leetcode.DP;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/17
 * \*  Time: 13:03
 * \*  Description:
 * \
 */

public class 分割等和子集 {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n<2) return false;
        int sum = 0,MaxNum =Integer.MIN_VALUE;
        for (int num : nums) {
            sum+=num;
            MaxNum = num > MaxNum ? num : MaxNum;
        }
        if(sum%2 == 1 || MaxNum>sum/2) return false;
        int target = sum/2;
        boolean[][] dp = new boolean[n][target+1];
        for(int i = 0;i<n;++i){
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for(int i = 1;i<n;++i){
            for(int j = 1;j<=target;++j){
                if(j>=nums[i]) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][target];
    }
}
