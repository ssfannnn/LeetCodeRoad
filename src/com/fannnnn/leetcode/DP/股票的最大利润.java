package com.fannnnn.leetcode.DP;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/13
 * \*  Time: 13:51
 * \*  Description:
 * \
 */

public class 股票的最大利润 {

    /**
     * 1.一次循环，对数组进行遍历，一旦遇到当前价格小于最低价，就最低价格更新为当前遍历到的price
     * 2.如果不是，那么计算当前的利润
     * 3.这样循环遍历到最后，得到的就是最高的利润
     * */

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxRet = 0;
        for (int price : prices) {
            if(price < minPrice){
                minPrice = price;
            }else {
                int nowPrice = price-minPrice;
                maxRet = maxRet > nowPrice ? maxRet : nowPrice;
            }
        }
        return maxRet;
    }
}
