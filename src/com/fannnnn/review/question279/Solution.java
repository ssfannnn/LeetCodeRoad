package com.fannnnn.review.question279;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/25
 * \*  Time: 10:35
 * \*  Description:
 * \
 */

public class Solution {

    /**
     *
     * */
    public static int numSquares(int n) {
        if(n==0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<=n;++i){
            dp[i] = i; //每一次给dp[i]初始化时将其看做是由i个1组成的，因此dp[i]初始化为i
            for(int j = 1;j<=Math.sqrt(i);++j){ //由于dp[i]可能是由它前面所有元素的其中一个的状态转化而来，因此需要将sqrt(i)前的元素都遍历一次
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    /**
     * 时间优化
     * */

    public static int numSquares2(int n) {
        if(n==0) return 0;
        int[] dp = new int[n+1];
        for(int i = 1;i<=n;++i){
            int min = Integer.MAX_VALUE;
            for(int j = 1;j*j<=i;++j){
                min = Math.min(min,dp[i-j*j]);
            }
            dp[i] = min+1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        numSquares(12);
    }
}
