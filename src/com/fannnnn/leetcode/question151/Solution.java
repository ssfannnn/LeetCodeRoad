package com.fannnnn.leetcode.question151;

import javafx.concurrent.Worker;

import java.util.*;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/27
 * \*  Time: 8:47
 * \*  Description:
 * \
 */

public class Solution {

    /**
     * 正则匹配
     * */
    public static String reverseWords(String s) {
        s = s.trim();
        List<String> res = Arrays.asList(s.split("\\s+"));
        Collections.reverse(res);
        return String.join(" ",res);
    }


    /**
     * 双端队列
     * */
    public static String reverseWords2(String s) {
        s = s.trim();
        int left = 0,right = s.length()-1;
        Deque<String> deque = new ArrayDeque<>();
        StringBuffer buffer = new StringBuffer();
        while (left<=right){
            char ch = s.charAt(left);
            if(ch!=' '){
                buffer.append(ch);
            }else if(ch==' '&& buffer.length()!=0){
                deque.offerFirst(buffer.toString());
                buffer = new StringBuffer();
            }
            ++left;
        }
        deque.offerFirst(buffer.toString());
        return String.join(" ",deque);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }
}
