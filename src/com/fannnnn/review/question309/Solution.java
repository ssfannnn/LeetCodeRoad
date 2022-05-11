package com.fannnnn.review.question309;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/27
 * \*  Time: 9:23
 * \*  Description:
 * \
 */

public class Solution {

    /**
     * 由题意可知 该题有三个状态
     * 1.第i天持有股票 dp[i][0]
     * 2.第i天未持有股票且在冷冻期 dp[i][1]
     * 3.第i天未持有股票且不在冷冻期 dp[i][2]
     *
     * 第i天持有股票的情况：说明可能是前一天就已经有的，或者是前一天才买的，说明这时不在冷冻期
     * 因此 dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
     *
     * 第i天不持有股票且在冷冻期的情况 说明必定是前一天卖出的
     * 因此 dp[i][1] = dp[i-1][0] + prices[i];
     *
     * 第i天不持有股票且不再冷冻期的情况 有两种可能 1.前一天不持有股票且不在冷冻期 2.前一天不持有股票且在冷冻期
     * 因此 dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2])
     * */

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp =  new int[n][3];
        dp[0][0] = -prices[0]; //持有股票
        dp[0][1] = 0; //未持有股票且在冷冻期
        dp[0][2] = 0; //未持有股票且不在冷冻期
        for(int i = 1;i<n;++i){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]);
        }
        return Math.max(dp[n-1][1],dp[n-1][2]);
    }
}
