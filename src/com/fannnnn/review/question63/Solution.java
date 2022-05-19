package com.fannnnn.review.question63;

import java.util.Arrays;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/19
 * \*  Time: 15:05
 * \*  Description:
 * \
 */

public class Solution {



    /**
     * 动态规划
     * */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0;i<n;++i){ //对于第一行的元素  如果不为obstacleGrid不为1 则对应dp表的元素为1 若遇到1 则该元素往后全为0
            if(obstacleGrid[0][i]==1) break;
            dp[0][i] = 1;
        }
        for(int i = 0;i<m;++i){ //第一列元素也是同理
            if(obstacleGrid[i][0]==1) break;
            dp[i][0] = 1;
        }
        for(int i = 1;i<m;++i){
            for(int j = 1;j<n;++j){
                if(obstacleGrid[i][j]==1) dp[i][j] = 0;  //遇到1 则dp对应的元素为0
                dp[i][j] = dp[i-1][j] + dp[i][j-1];  //否则 等于上方的格子的路径数+左边格子的路径数
            }
        }
        return dp[m-1][n-1];
    }
}
