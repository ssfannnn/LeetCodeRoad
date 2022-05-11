package com.fannnnn.leetcode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/18
 * \*  Time: 15:02
 * \*  Description:
 * \
 */

public class 分割回文串 {

    /**
     * 1.动态规划对字符串进行预处理，f[i][j],判断字符串中从第i个字符到第j个字符是不是回文字符串{
     *     首先对所有单个字符进行赋值，由于每一个单个字符都属于回文字符  因此都赋值为true
     *     然后，使用中心扩展法  状态转移方程为: f[i][j] = (s.charAt(i)==s.charAt(j))&&f[i+1][j-1]
     * }
     *
     * 2.从s的第0个字符开始进行深搜，一旦搜索到最后一个，将当前的list加入res中
     * 3.如果f[i][j]==true，那么下一次递归从字符串的第j+1的开始，跳出当前层递归以后，移除list中的最后一个元素
     *
     * */

    List<List<String>> res;
    List<String> list;
    boolean[][] f;
    public List<List<String>> partition(String s){
        int n = s.length();
        res = new ArrayList<>();
        list = new ArrayList<>();
        f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i],true);
        }

        for(int i = n-1;i>=0;--i){
            for(int j = i+1;j<n;++j){
                f[i][j] = (s.charAt(i)==s.charAt(j)) && f[i+1][j-1];
            }
        }
        dfs(s,0);
        return res;
    }

    private void dfs(String s, int i) {
        if(i==s.length()){
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int j = i;j<s.length();++j){
            if(f[i][j]){
                list.add(s.substring(i,j+1));
                dfs(s,i+1);
                list.remove(list.size()-1);
            }
        }
    }
}
