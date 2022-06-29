package com.fannnnn.reviewAgain.question221;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/29
 * \*  Time: 16:13
 * \*  Description:
 * \
 */

public class Solution {


    /**
     *动态规划 dp数组用来存储以当前位置为右下角的最大正方形边长
     * 一旦遇到matrix[i][j] = ‘1’，如果当前坐标是在第一行或者第一列，那么面积只能为1，因为dp[i][j]此时恒为1
     * 否则dp[i][j] 为 dp[i-1][j]、dp[i][j-1]、dp[i-1][j-1]中的最小值，因为一旦这三个位置中有一个为0，则不能组成一个闭合的正方形
     * 因此状态转移方程为 dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1
     *
     * */
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int maxSquare = 0;
        for(int i = 0;i < n;++i){
            for(int j = 0;j<m;++j){
                if(matrix[i][j] == 0) dp[i][j] = 0;
                else if(matrix[i][j]=='1'){
                    if(i==0 || j==0) dp[i][j] = 1;
                    else {
                        dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                    }
                }
                maxSquare = Math.max(maxSquare,dp[i][j]);
            }
        }
        return maxSquare * maxSquare;
    }
}
