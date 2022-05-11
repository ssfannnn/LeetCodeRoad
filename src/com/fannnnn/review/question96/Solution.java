package com.fannnnn.review.question96;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/22
 * \*  Time: 8:58
 * \*  Description:
 * \
 */

public class Solution {

    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=n;++i){
            for(int j = 1;j<=i;++j){
                dp[i] = dp[i-j] * dp[j-1];
            }
        }
        return dp[n];
    }

}
