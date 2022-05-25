package com.fannnnn.leetcode.question739;

import java.util.Arrays;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/25
 * \*  Time: 16:39
 * \*  Description:
 * \
 */

public class Solution {

    /**
     * 暴力求解
     * */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i = 0;i<n;++i){
            int days = 0;
            for(int j = i;j<n;++j){
                if(temperatures[j] > temperatures[i]){
                    days++;
                    res[i] = days;
                    break;
                }else if(temperatures[j] <= temperatures[i]){
                    days++;
                }
            }
        }
        return res;
    }

    /**
     *
     * */
    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] dp = new int[n];
        Arrays.fill(dp,0);
        for(int i = n-2;i>=0;--i){
            for(int j = i+1;j<n;j+=dp[j]){
                if(temperatures[j] > temperatures[i]){
                    dp[i] = j-i;
                    break;
                }else if(dp[j]==0){
                    dp[i] = 0;
                    break;
                }
            }
        }
        return dp;
    }
}
