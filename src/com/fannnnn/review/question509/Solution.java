package com.fannnnn.review.question509;

import com.sun.corba.se.impl.ior.IdentifiableFactoryFinderBase;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/15
 * \*  Time: 10:15
 * \*  Description:
 * \
 */

public class Solution {


    /**
     * 动态规划代替暴力递归
     * */
    public int fib(int n) {
        if(n==0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<=n;++i){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
