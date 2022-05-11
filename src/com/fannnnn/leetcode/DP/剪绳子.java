package com.fannnnn.leetcode.DP;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/11
 * \*  Time: 9:05
 * \*  Description:
 * \
 */

public class 剪绳子 {

    /**
     * 分为三种情况:
     *          1.不剪绳子
     *          2.剪第一刀 不剪第二刀
     *          3.剪好几刀
     *
     * 因此状态转移方程为: Math.max(dp[i],Math.max((i-j)*j,j*dp[i-j]);
     * */

    public static int cuttingRope(int n) {
        int[] dp = new int[n+11];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2;i<=n;++i){
            int max = dp[i];
            for(int j = 1;j<=i;++j){
                max = Math.max(max,Math.max((i-j)*j,j*dp[i-j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(2));
    }
}
