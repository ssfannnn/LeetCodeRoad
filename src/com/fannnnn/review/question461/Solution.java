package com.fannnnn.review.question461;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/30
 * \*  Time: 9:08
 * \*  Description:
 * \
 */

public class Solution {


    /**
     * 异或运算  最后计算的结果有多少位1，说明有多少位不同
     * */
    public int hammingDistance(int x, int y) {
        int z = x^y;
        int res = 0;
        while (z!=0){
            int cur = z % 2;;
            if(cur==1) res++;
            z/=2;
        }
        return res;
    }
}
