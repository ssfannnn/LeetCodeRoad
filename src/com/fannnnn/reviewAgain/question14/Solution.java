package com.fannnnn.reviewAgain.question14;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/4
 * \*  Time: 8:55
 * \*  Description:
 * \
 */

public class Solution {


    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len==1) return strs[0];
        int res = 0;
        int min = strs[0].length();
        for(int i = 1;i<len;++i){  //预处理字符串数组 找出数组中最短的那个字符串并记录次长度
            min = Math.min(min,strs[i].length());
        }
        for (int k = 0;k<min;++k) { //从头开始遍历字符串
            char ch = strs[0].charAt(k);
            for(int i = 1;i<len;++i){  //第二层循环循环遍历数组中的每一个字符串
                if(strs[i].charAt(k)!=ch) return strs[0].substring(0,res); //如果出现不等的 直接将该字符之前的字符串返回
                else if(strs[i].charAt(k)==ch && i==len-1) res++; // 如果遍历到了数组的最后一个字符串并且数组中每个字符串的第k个位置都与第一个字符串的第k个位置相等，最长前缀+1
            }
        }
        return strs[0].substring(0,res);
    }

    public static void main(String[] args) {
        String[] arr = {"flower","flow","flight"};
        longestCommonPrefix(arr);
    }
}
