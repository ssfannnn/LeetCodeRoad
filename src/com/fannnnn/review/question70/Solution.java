package com.fannnnn.review.question70;

public class Solution {

    /**
     * 斐波那契数列  a[n] = a[n-1] + a[n-2],打个表就出来了
     * */
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 3;i<=n;++i){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
