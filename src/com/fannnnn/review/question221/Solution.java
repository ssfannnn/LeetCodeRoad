package com.fannnnn.review.question221;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/25
 * \*  Time: 7:35
 * \*  Description:
 * \
 */

public class Solution {

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length,m = matrix[0].length;
        if(n==0 || m==0 || matrix==null) return 0;
        int[][] dp = new int[n][m];
        int max = 0;
        for(int i = 0;i<n;++i){
            for(int j = 0;j<m;++j){
                if(matrix[i][j]=='1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    }
                    max = max > dp[i][j] ? max : dp[i][j];
                }
            }
        }
        return max*max;
    }
}
