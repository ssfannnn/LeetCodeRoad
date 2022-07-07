package com.fannnnn.review.offer58;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/7/7
 * \*  Time: 9:35
 * \*  Description:
 * \
 */

public class Solution {
    public String reverseLeftWords(String s, int n) {
        return new StringBuffer().append(s.substring(n,s.length())).append(s.substring(0,n-1)).toString();
    }
}
