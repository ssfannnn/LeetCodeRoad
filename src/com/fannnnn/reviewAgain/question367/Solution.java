package com.fannnnn.reviewAgain.question367;

import java.awt.font.NumericShaper;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/20
 * \*  Time: 10:21
 * \*  Description:
 * \
 */

public class Solution {

    public boolean isPerfectSquare(int num) {
        long left = 0,right = num;
        while (left<=right){
            long mid = left + ((right-left)>>1);
            long x = mid * mid;
            if(x == num) return true;
            else if(x < num) left = mid +1;
            else if(x > num) right = mid - 1;
        }
        return false;
    }
}
