package com.fannnnn.review.question121;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/23
 * \*  Time: 8:23
 * \*  Description:
 * \
 */

public class Solution {

    /**
     *看到这道题 第一反应是动态规划，但实际上这只是个一维问题，完全可以不需要dp数组来记录dp[i]的最大利润
     * 首先我们需要先定义一个当前位置的最小值，从左往右遍历，一旦遇到比min小的元素，就将该元素赋给min
     * 一旦遇到比min大的，就算出他们的差值，与之前已经算出的res进行比较，取其中大的值
     * */

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0;i<n;++i){
            if(prices[i] < min){
                min = prices[i];
            }else {
                res = Math.max(res,prices[i]-min);
            }
        }
        return res;
    }
}
