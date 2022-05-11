package com.fannnnn.leetcode.DP;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/9
 * \*  Time: 13:24
 * \*  Description:
 * \
 */

public class 最佳买卖股票时机含冷冻期 {

    /***
     *
     * */

    public int maxProfit(int[] prices) {
       int n = prices.length;
       if(n==0) return 0;
       int[][] dp = new int[n][3];
       dp[0][0] = -prices[0];
       for(int i = 1;i<n;++i){
           dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
           dp[i][1] = Math.max(dp[i-1][1],dp[i-1][2]);
           dp[i][2] = dp[i-1][0] + prices[i];
       }
       return Math.max(dp[n-1][1],dp[n-1][2]);
    }
}
