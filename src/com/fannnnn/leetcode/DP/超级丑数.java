package com.fannnnn.leetcode.DP;

import java.util.Arrays;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/18
 * \*  Time: 16:05
 * \*  Description:
 * \
 */

public class 超级丑数 {

    /**
     * 与丑数2不同的一点就是质因子数组从[2,3,5]变为不确定的primes
     * */

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        int m = primes.length;
        int[] pointers = new int[m];
        Arrays.fill(pointers,1);
        int[] temp = new int[m];
        for(int i = 2;i<=n;++i){
            for (int x = 0; x < m; x++) {
                temp[x] = primes[x] * dp[pointers[x]];
            }
            int min = Arrays.stream(temp).min().getAsInt();
            dp[i] = min;
            for (int k = 0;k<m;++k){
                if(dp[i]==temp[k]){
                    pointers[k]++;
                }
            }
        }
        return dp[n];
    }
}
