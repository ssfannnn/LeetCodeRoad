package com.fannnnn.review.question5;

import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/19
 * \*  Time: 14:59
 * \*  Description:
 * \
 */

public class 最长回文子串 {

    /**
     * dp[i][j]定义 从字符串的第i个位置到第j个位置的字符串是否是回文字符串
     * */

    public static String longestPalindrome(String s) {
        int n = s.length();
        if(n<2) return s;
        boolean[][] dp = new boolean[n][n];
        //单个字符一定是回文字符
        for(int i = 0;i<n;++i){
            dp[i][i] = true;
        }
        int maxlen = 1;
        int begin = 0;
        //字符串的长度为2开始
        for(int len = 2;len<=n;++len){
            //i表示左指针
            for(int i = 0;i<n;++i){
                //j表示右指针
                int j = len+i-1;
                //如果右指针越界  直接break
                if(j>=n) break;
                //如果左右指针指向的字符不一样 说明一定不是回文字符
                if(s.charAt(i)!=s.charAt(j)) dp[i][j] = false;
                else {
                    //如果一样 且该i-j的字符串长度<3 说明是单个字符 或者两个一样的字符组成的字符串
                    if(j-i<3) dp[i][j] = true;
                    //如果长度大于3，那么需要看第i+1个字符到第j-1个字符的字符串是不是回文字符 这里其实用到中心扩展的思想
                    else dp[i][j] = dp[i+1][j-1];
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
        System.out.println(longestPalindrome("ac"));
    }

}
