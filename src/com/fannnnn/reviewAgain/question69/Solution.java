package com.fannnnn.reviewAgain.question69;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/20
 * \*  Time: 10:03
 * \*  Description:
 * \
 */

public class Solution {


    /**
     * 二分查找
     * */
    public int mySqrt(int x) {
        int left = 0,right = x,ans = -1;
        while (left<=right){
            int mid = left + ((right-left)>>1);
            if((long)mid * mid * 1.0 <=x ){
                ans = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
