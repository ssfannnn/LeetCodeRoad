package com.fannnnn.leetcode.DP;

import com.sun.deploy.panel.ITreeNode;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/6
 * \*  Time: 9:38
 * \*  Description:
 * \
 */

public class 买卖股票的最佳时机 {

    /**
     * dp[i][0]用来记录第i天手里未持有股票时的利润  dp[i][1]用来记录第i天手机持有股票时的利润
     * 因此我们来分析状态转移方程
     * dp[i][0] 分为两种情况-  第i-1天未持有股票，第i天也未持有股票 此时dp[i][0] = dp[i-1][0]
     *                    - 第i-1天持有股票,第i天未持有股票 说明第i天已将股票卖出 此时dp[i][0] = dp[i-1][1] + price[i]
     *
     * dp[i][1] 也分为两种情况 - 第i-1天未持有股票 第i天持有股票 此时dp[i][1] = dp[i-1][0] - price[i]
     *                        第i-1天持有股票 第i天也持有股票 此时dp[i][1] = dp[i-1][1]
     *
     * 因此状态转移方程 dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + price[i])
     *     dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - price[i])
     * */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1;i<n;++i){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}
