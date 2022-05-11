package com.fannnnn.review.question338;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/27
 * \*  Time: 10:24
 * \*  Description:
 * \
 */

public class Solution {

    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i = 0;i<n;++i){
            if(i%2==1) {
                res[i] = res[i-1]+1;  //如果i%2==1 说明是在前一个数的基础上+1
            }else {
                res[i] = res[i/2]; //i%2==0  由于i左移或右移 1的数量会保持不变 因此res[i] = res[i/2]
            }
        }
        return res;
    }
}
