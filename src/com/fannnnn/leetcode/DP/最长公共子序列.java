package com.fannnnn.leetcode.DP;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/10
 * \*  Time: 11:13
 * \*  Description:
 * \
 */

public class 最长公共子序列 {

    /**
     * dp[i][j]表示第一个字符串的前i个位置和第二个字符串的前j个位置的最长公共子序列
     * 如果 text1.charAt(i) != text2.charAt(j) 则取dp[i-1][j]和dp[i][j-1]中的较大值
     * 如果 text1.charAt(i) == text2.charAt(j) 则dp[i][j] = dp[i-1][j-1] + 1.
     * */

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(),len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 1;i<=len1;++i) {
            for(int j = 1;j<=len2;++j){
                if(text1.charAt(i-1)!=text2.charAt(j-1)){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }else {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
