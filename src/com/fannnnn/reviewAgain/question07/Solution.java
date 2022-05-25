package com.fannnnn.reviewAgain.question07;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/23
 * \*  Time: 14:11
 * \*  Description:
 * \
 */

public class Solution {

    public int reverse(int x) {
        int sum = 0;
        while (x!=0){
            int temp = x%10;
            if (x>214748364 || (x==214748364 && temp>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (x<-214748364 || (x==-214748364 && temp<-8)) {
                return 0;
            }
            sum = sum * 10 + temp;
            x/=10;
        }
        return sum;
    }
}
