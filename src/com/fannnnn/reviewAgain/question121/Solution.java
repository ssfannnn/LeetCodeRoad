package com.fannnnn.reviewAgain.question121;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/5
 * \*  Time: 9:47
 * \*  Description:
 * \
 */

public class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int res = 0;
        for(int i = 1;i<n;++i){
            if(prices[i] < min) {
                min = prices[i];
            }
            res = Math.max(prices[i]-min,0);
        }
        return res;
    }
}
