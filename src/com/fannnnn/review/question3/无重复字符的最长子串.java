package com.fannnnn.review.question3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
\*  Created with IntelliJ IDEA.
\*  @author shensifan
\*  Date: 2022/4/19
\*  Time: 14:32
\*  Description:
\*/

public class 无重复字符的最长子串 {

    /**
     * 1.初始left = 0，max= 0；
     * 2.从字符串的第0个位置开始遍历，如果没有遇到重复字符，全部放入哈希表中，如果遇到重复字符 ，更新最左侧边界left
     * 3.维护一个max，指针每次往走的时候，都需要更新max
     * 4.最终答案为max的最大值  --》 max = Math.max(max,i-l+1)  i-l+1表示此时字符串的长度
     * * */
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int l = 0;
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for(int i = 0;i<n;++i){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                l = Math.max(l,map.get(ch)+1);
            }
            map.put(ch,i);
            max = Math.max(max,i-l+1);
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
