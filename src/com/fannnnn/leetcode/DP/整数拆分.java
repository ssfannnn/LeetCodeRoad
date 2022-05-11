package com.fannnnn.leetcode.DP;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/10
 * \*  Time: 8:24
 * \*  Description:
 * \
 */

public class 整数拆分 {

    /**
     * dp[i] 表示n=i时，所划分的正整数的最大乘积
     * 由于n>=2，因此计算过程如下：
     * ①：从1开始遍历到i，没到一个数 以接下来分和不分做选择，如果不分，那么dp[i] = (i-j)*j  如果分,那么dp[i] = j*dp[i-j]
     * ②因此状态转移方程为 dp[i] = Math.max(max,Math.max(dp[i-j]*j,j*(i-j));
     * */

    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for(int i = 2;i<=n;++i){
            int max = 0;
            for(int j = 1;j<=i;++j){
                max = Math.max(max,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
