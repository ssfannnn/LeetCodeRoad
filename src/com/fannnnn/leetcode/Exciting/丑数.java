package com.fannnnn.leetcode.Exciting;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/18
 * \*  Time: 15:24
 * \*  Description:
 * \
 */

public class 丑数 {

    public boolean isUgly(int n) {
        if(n==1) return true;
        if(n%2==0) return isUgly(n/2);
        if(n%3==0) return isUgly(n/3);
        if(n%5==0) return isUgly(n/5);
        return false;
    }
}
