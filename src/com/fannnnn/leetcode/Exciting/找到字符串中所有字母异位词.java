package com.fannnnn.leetcode.Exciting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/17
 * \*  Time: 13:30
 * \*  Description:
 * \
 */

public class 找到字符串中所有字母异位词 {

    public static List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        if(n<m) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int[] sr = new int[26];
        int[] pr = new int[26];
        for(int i = 0;i<m;++i){
            ++sr[s.charAt(i)-'a'];
            ++pr[p.charAt(i)-'a'];
        }
        if(Arrays.equals(sr,pr)) {
            res.add(0);
        }

        for(int i = 0;i<n-m;++i){
            --sr[s.charAt(i)-'a'];
            ++sr[s.charAt(i+m)-'a'];
            if(Arrays.equals(sr,pr)) res.add(i+1);
        }
        return res;
    }


    public static void main(String[] args) {
        findAnagrams("cbaebabacd","abc");
    }
}
