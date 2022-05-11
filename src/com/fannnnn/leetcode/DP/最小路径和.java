package com.fannnnn.leetcode.DP;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/7
 * \*  Time: 20:51
 * \*  Description:
 * \
 */

public class 最小路径和 {

    /**
     * ① 要找到数字和最小的通路，我们只需要记录当途径某个格子时  该格子的最小步数
     * ②因此设置dp数组，在第一行上 每个格子的和都为该格子的数值+该格子左侧的最大值 即grid[0][j]+dp[0][j-1]  dp[0][0] = grid[0][0]
     * ③对于第一列 由于只能从上方到达 因此dp[j][0] = dp[j-1][0] + grid[j][0]
     * ④对于每一个普遍位置 它既能从上面到达 也能从左边到达 因此要去上方格子和左边格子中的较小值 因此状态转移方程为 dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
     *
     *      dp[i][j] = {
     *
     *          grid[0][j]+dp[0][j-1] ; row == 0;
     *          dp[j-1][0] + grid[j][0]; col == 0
     *          dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];  row >= 1 && col >=1
     *
     *      }
     *
     * */

    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for(int i = 1;i<m;++i){
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }
        for(int j = 1;j<n;++j){
            dp[j][0] = dp[j-1][0] + grid[j][0];
        }
        for(int i = 1;i<n;++i){
            for(int j = 1;j<m;++j){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }
}
