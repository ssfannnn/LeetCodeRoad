package com.fannnnn.review.question62;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/22
 * \*  Time: 7:33
 * \*  Description:
 * \
 */

public class Solution {


    /**
     * 1.当机器人在第一行时，只能从左边的格子进入 因此 dp[0][i] = 1
     * 2.当机器人在第一列是，只能从上方的格子进入 因此dp[i][0] = 1
     * 3.对于任意一个普遍位置 既可以从上方进入 也可以从左边进入 因此dp[i][j] = dp[i-1][j] + dp[i][j-1];
     *
     * 因此状态转移方程为: {
     *      dp[i][j] = 1  i=0 ,j=0
     * }             = dp[i-1][j] + dp[i][j-1] 1<i<m,1<j<n
     *
     * */

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0;i<m;++i){
            dp[0][i] = 1;
        }
        for(int i = 0;i<n;++i){
            dp[i][0] = 1;
        }
        for(int i = 1;i<m;++i){
            for(int j = 1;j<n;++j){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
