package com.fannnnn.reviewAgain.question12;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/7/28
 * \*  Time: 10:54
 * \*  Description:
 * \
 */

public class Solution {

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int n = values.length;
        StringBuffer buffer = new StringBuffer();
        for(int i = 0;i<n;++i){
            while (num >= values[i]){
                buffer.append(symbols[i]);
                num-=values[i];
            }
            if(num==0) break;
        }
        return buffer.toString();
    }
}
