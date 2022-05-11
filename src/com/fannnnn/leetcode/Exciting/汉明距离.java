package com.fannnnn.leetcode.Exciting;

import java.sql.SQLOutput;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/17
 * \*  Time: 14:18
 * \*  Description:
 * \
 */

public class 汉明距离 {

    public static int hammingDistance(int x, int y) {
        System.out.println(100 % 3.0);
        int num = x^y;
        int cnt = 0;
        while (num!=0){
            if(num%2==1) cnt++;
            num/=2;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }
}
