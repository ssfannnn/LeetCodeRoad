package com.fannnnn.leetcode.DP;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/9
 * \*  Time: 11:38
 * \*  Description:
 * \
 */

public class 完全平方数 {

    /**
     * dp[i-j*j],代表i减去一个平方数后的所包含的平方数的多少 再+1，即为dp[i]包含的平方数的最小数量
     * 状态转移方程为 dp[i] = Math.min(dp[i-j*j],min) + 1;
     * */

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i = 1;i<=n;++i){
            int min = Integer.MAX_VALUE;
            for(int j = 1;j*j<=i;++j){
                min = Math.min(min,dp[i-j*j]);
            }
            dp[i] = min+1;
        }
        return dp[n];
    }
}
