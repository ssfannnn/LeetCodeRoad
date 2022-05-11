package com.fannnnn.leetcode.DFS;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/11
 * \*  Time: 16:06
 * \*  Description:
 * \
 */

public class 字符串的排列 {


    List<String> res;
    boolean[] vis;
    public String[] permutation(String s) {
        res = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int n = s.length();
        vis = new boolean[n];
        StringBuffer buffer = new StringBuffer();
        searchPermutation(chars,0,n,buffer);
        String[] ans = new String[res.size()];
        int index = 0;
        while (!res.isEmpty()){
            ans[index++]  = res.get(0);
            res.remove(0);
        }
        return ans;
    }

    private void searchPermutation(char[] chars, int i, int n, StringBuffer buffer) {
        if(i==n){
            res.add(buffer.toString());
            return ;
        }
        for(int k = 0;k < n;++k){
            if(vis[k] || ( k>0 && !vis[k-1] && chars[k-1]==chars[k])) continue;
            vis[k] = true;
            buffer.append(chars[k]);
            searchPermutation(chars,i+1,n,buffer);
            buffer.deleteCharAt(buffer.length()-1);
            vis[k] = false;
        }
    }


}
