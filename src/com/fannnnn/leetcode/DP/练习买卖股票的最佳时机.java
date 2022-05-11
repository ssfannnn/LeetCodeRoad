package com.fannnnn.leetcode.DP;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/14
 * \*  Time: 16:12
 * \*  Description:
 * \
 */

public class 练习买卖股票的最佳时机 {


    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0;i<prices.length;++i){
            if(prices[i] < min) {
                min = prices[i];
            }else {
                int now = prices[i] - min;
                res = now > res ? now : res;
            }
        }
        return res;
    }
}
