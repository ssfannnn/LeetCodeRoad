package com.fannnnn.leetcode.DP;

import java.sql.Connection;
import java.util.Arrays;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/8
 * \*  Time: 8:34
 * \*  Description:
 * \
 */

public class 零钱兑换 {

    /**
     * 根据题意 每个硬币都是可以重复使用的， 定义dp数组 dp[i]表示在金钱为i时所能用到的货币最少数量
     * ① dp[0]等于0 表示金额为0时，需要硬币0张
     * ②由于每一次dp[i]都是由某一个状态转移而来 例如 coins = [1,2,5]  i = 6;  dp[6] = min (dp[6-1] , dp[6-2] , dp[6-5]) + 1;
     * 因此状态转移方程为                     dp[i] = Math.min(dp[i],dp[i - coins[j]]+1);
     *
     * */

    public int coinChange(int[] coins, int amount) {
        if (coins==null || coins.length==0 || amount<=0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i = 1;i <= amount;++i){
            for(int j = 0;j<coins.length;++j){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i],dp[i - coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


}
