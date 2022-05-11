package com.fannnnn.leetcode.DP;

import com.sun.org.omg.CORBA.ContextIdSeqHelper;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/23
 * \*  Time: 16:49
 * \*  Description:
 * \
 */

public class 零钱兑换2 {



    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for(int i = coin;i<=amount;++i){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }


}
