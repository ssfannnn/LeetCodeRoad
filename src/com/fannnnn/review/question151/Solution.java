package com.fannnnn.review.question151;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/7/7
 * \*  Time: 9:23
 * \*  Description:
 * \
 */

public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int left = 0,right = s.length()-1;
        Deque<StringBuffer> deque = new ArrayDeque<>();
        StringBuffer buffer = new StringBuffer();
        while (left<=right){
            char ch = s.charAt(left);
            if(ch!=' '){
                buffer.append(ch);
            }else if(ch==' ' && buffer.length()!=0){  //buffer.length！=0这个条件是用来筛出连续两个空格的情况
                deque.offerFirst(buffer);
                buffer = new StringBuffer();
            }
            left++;
        }
        deque.offerFirst(buffer);
        return String.join(" ",deque);
    }
}
