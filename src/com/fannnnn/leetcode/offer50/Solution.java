package com.fannnnn.leetcode.offer50;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/28
 * \*  Time: 8:24
 * \*  Description:
 * \
 */

public class Solution {

    public char firstUniqChar(String s) {
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch-'a']++;    //存储每个出现的字符
        }
        for (char ch : s.toCharArray()) {
            if(arr[ch-'a'] == 1) return ch; //从字符串首字母开始遍历，如果对应的出现次数为1，直接return该字符
        }
        return ' ';
    }
}
