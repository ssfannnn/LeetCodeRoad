package com.fannnnn.leetcode.DFS;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/4
 * \*  Time: 9:13
 * \*  Description:
 * \
 */

public class 全排列 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean[] visit = new boolean[n];
        dfs(nums,n,visit,list);
        return res;
    }

    public void dfs(int[] nums, int n, boolean[] visit,List<Integer> list) {
        if(list.size() == n){
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int i = 0;i<n;++i){
            //如果当前字符没被用过就将其放入list集合中
            if(!visit[i]){
                visit[i] = true;
                list.add(nums[i]);
                //进行下一层递归
                dfs(nums,n,visit,list);
                //移除最后一个元素
                list.remove(list.size()-1);
                //将最后一个最后设为未使用过 以便下一次递归使用
                visit[i] = false;
            }
        }
    }
}
