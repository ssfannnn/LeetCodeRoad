package com.fannnnn.leetcode.DP;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/21
 * \*  Time: 9:41
 * \*  Description:
 * \
 */

public class 把数字翻译成字符串 {

    public int translateNum(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=n;++i){
            int x = (nums[i-1]-'0')*10 + (nums[i]-'0');
            if(x>=10&&x<=25){
                dp[i] = dp[i-2] + dp[i-1];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[n];
    }
}
