package com.fannnnn.leetcode.DP;

import java.lang.annotation.Target;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/8
 * \*  Time: 11:25
 * \*  Description:
 * \
 */

public class 三角形最小路径和 {

    /**
     * 要求从上至下的最短路径 因此我们可以记录从最上层到下面的每一个结点的最短路径，每一部分都求出最短 那么到最后的答案便是最短路径
     * ①首先 要定义第一列的dp值，由于第一列只能从上面的元素下来，因此 dp[i][0] = dp[i-1][0] + triangle.get(i)+get(0)
     * ②对于对角线的值 只能从左上角走下来 因此dp[i][i] = dp[i-1]+dp[i-1] + triangle.get[i].get[i]
     * ③对于任意普遍位置 既可以从上面的格子走下来 也可以从左上角的格子走下来  因此 dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j)
     *
     * 因此状态转移方程为:
     *                  dp[i][j] = {
     *
     *                      dp[i][0] = dp[i-1][0] + triangle.get(i)+get(0);j==0
     *                      dp[i][i] = dp[i-1]+dp[i-1] + triangle.get[i].get[i]; i==j
     *                      dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j)     i > j > 0
     *                  }
     * */

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n==1) return triangle.get(0).get(0);
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1;i<n;++i){
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            for(int j  = 1;j < i;++j){
                int num = triangle.get(i).get(j);
                dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + num;
            }
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<n;++i){
            ans = ans < dp[n-1][i] ? ans : dp[n-1][i];
        }
        return ans;
    }
}
