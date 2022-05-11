package com.fannnnn.leetcode.Tree;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/14
 * \*  Time: 15:29
 * \*  Description:
 * \
 */

public class 不同的二叉搜索树 {


    /**
     * 笛卡尔积 即求两个集合的积
     *假设共有n个结点
     * 那么 G(i) += G(j-1) * G(i-j)
     * */
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=n;++i){
            for(int j = 1;j<i;++j){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
