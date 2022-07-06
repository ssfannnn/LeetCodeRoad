package com.fannnnn.review.question344;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/7/6
 * \*  Time: 8:58
 * \*  Description:
 * \
 */

public class Solution {

    public void reverseString(char[] s) {
        int left = 0,right = s.length-1;
        while (left<=right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
