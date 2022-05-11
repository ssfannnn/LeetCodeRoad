package com.fannnnn.leetcode.DP;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/8
 * \*  Time: 9:54
 * \*  Description:
 * \
 */

public class 不同路径2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length,n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[m][n];
        for(int i = 0;i<n;++i){
            if(obstacleGrid[0][i] == 1){
                break;
            }
            dp[0][i] = 1;
        }

        for(int j = 0;j<m;++j){
            if(obstacleGrid[j][0] == 1){
                break;
            }
            dp[j][0] = 1;
        }

        for(int i = 1;i<m;++i){
            for(int j = 1;j<n;++j){
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
