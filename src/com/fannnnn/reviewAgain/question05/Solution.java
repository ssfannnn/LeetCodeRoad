package com.fannnnn.reviewAgain.question05;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/25
 * \*  Time: 8:42
 * \*  Description:
 * \
 */

public class Solution {


    /**
     * 动态规划 dp[i][j]表示从第i个字符到第j个字符所组成的字符串是不是回文字符串
     * */
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n<2) return s;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0;i<n;++i){
            dp[i][i] = true;
        }
        int max = 1;
        int begin = 0;
        for(int len = 2;len<=n;++len){ //表示字符串长度
            for(int i = 0;i<n;++i){ //i表示左指针
                int j = i+len-1; //j表示右指针
                if(j>=n) break;
                if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j] = false;
                }
                else {
                    if(j-i<3) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                }
                if(dp[i][j] && j-i+1>max){
                    begin = i;
                    max  = j-i+1;
                }
            }
        }
        return s.substring(begin,begin+max);
    }
}
