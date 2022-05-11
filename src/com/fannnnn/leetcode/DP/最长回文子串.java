package com.fannnnn.leetcode.DP;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/18
 * \*  Time: 16:37
 * \*  Description:
 * \
 */

public class 最长回文子串 {

    public static String longestPalindrome(String s) {
        int n = s.length();
        if(n<2) return s;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0;i<n;++i){
            dp[i][i] = true;
        }
        int maxlen = 1;
        int begin = 0;
        for(int len = 2;len <= n;++len){
            for(int i = 0;i<n;++i){
                int j = len+i-1;
                if(j >= n) break;
                if(s.charAt(i)!=s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if(j-i<3) {
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && j-i+1 > maxlen){
                    begin = i;
                    maxlen = j-i+1;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
