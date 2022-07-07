package com.fannnnn.leetcode.question459;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/7/7
 * \*  Time: 9:47
 * \*  Description:
 * \
 */

public class Solution {

    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s,1)!=s.length();
    }

    public static void main(String[] args) {
        System.out.println("shenshenshenshen".indexOf("shenshen",1));
    }
}
