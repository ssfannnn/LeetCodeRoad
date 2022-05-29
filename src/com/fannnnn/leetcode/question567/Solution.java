package com.fannnnn.leetcode.question567;

import java.util.Arrays;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/29
 * \*  Time: 10:13
 * \*  Description:
 * \
 */

public class Solution {

    /**
     * 滑动窗口
     * */
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(),n = s2.length();
        if(m > n) return false;
        int[] cnt1 = new int[26]; //统计s1中各个字符的个数
        int[] cnt2 = new int[26]; //统计s2中各个字符的个数
        for(int i = 0;i<m;++i){
            ++cnt1[s1.charAt(i)-'a'];
            ++cnt2[s2.charAt(i)-'a'];
        }
        if(Arrays.equals(cnt1,cnt2)) return true;
        for(int i = m;i<n;++i){  //从s2的第m个字符开始遍历
            ++cnt2[s2.charAt(i)-'a'];  //滑动窗口往右滑动 右边的元素进来
            --cnt2[s2.charAt(i-m)-'a']; //窗口最右侧的元素出去
            if(Arrays.equals(cnt1,cnt2)) return true;
        }
        return false;
    }
}
