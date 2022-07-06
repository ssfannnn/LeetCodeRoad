package com.fannnnn.review.question541;

import java.util.Locale;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/7/6
 * \*  Time: 9:07
 * \*  Description:
 * \
 */

public class Solution {


    /**
     * 循环当中每次使 i+2*k即可
     * a = a^b
     * b = b ^ (a ^ b) = a
     * a = a ^ b ^ a
     *
     * */

    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] str = s.toCharArray();
        for (int i = 0;i<n;i+=2*k){
            int begin = i;
            int end = Math.min(n-1,i+k-1);
            while (begin < end){ //异或运算进行翻转
                str[begin] ^= str[end];
                str[end] ^= str[begin];
                str[begin] ^= str[end];
                begin++;
                end--;
            }
        }
        return new String(str);
    }


}
