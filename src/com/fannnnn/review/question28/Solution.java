package com.fannnnn.review.question28;

import jdk.nashorn.internal.runtime.linker.NashornBeansLinker;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/7/7
 * \*  Time: 9:40
 * \*  Description:
 * \
 */

public class Solution {

    /**
     * 滑动窗口
     * */
    public int strStr(String haystack, String needle) {
        if(needle==null || needle.length()==0) return 0;
        int length = needle.length();
        int res = -1;
        for(int i = 0;i<=haystack.length()-length;++i){
            if(needle.equals(haystack.substring(i,i+length))){
                res = i;
                break;
            }
        }
        return res;
    }
}
