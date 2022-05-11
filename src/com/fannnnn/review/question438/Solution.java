package com.fannnnn.review.question438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/29
 * \*  Time: 9:42
 * \*  Description:
 * \
 */

public class Solution {

    /**
     * 由题意 我们可以定义两个数组，一个放p的所有字符出现的次数  一个放s的所有字符出现的次数
     * 只要两个数组完全一致 那么res中就加上当前s的起点坐标+1
     * */

    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        if(n<m) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<>();
        int[] sar = new int[26];
        int[] par = new int[26];
        //将p的字符和s的前m个字符都放入数组当中，检查两个数组是否相等
        for(int i = 0;i<m;++i){
            ++sar[s.charAt(i)-'a'];
            ++par[p.charAt(i)-'a'];
        }
        if(Arrays.equals(sar,par)) res.add(0);

        for(int i = 0;i<n-m;++i){
            --sar[s.charAt(i)-'a'];
            ++sar[s.charAt(i+m)-'a'];
            if(Arrays.equals(sar,par)) res.add(i+1);
        }
        return res;
    }
}
