package com.fannnnn.leetcode.DP;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/18
 * \*  Time: 17:04
 * \*  Description:
 * \
 */

public class 统计各位数字都不同的数字个数 {

    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        if(n==1) return  10;
        int res = 10,cur = 9;
        for(int i = 0;i<n-1;++i){
            cur*=9-i;
            res+=cur;
        }
        return res;
    }
}
