package com.fannnnn.review.question77;

import java.util.ArrayList;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/20
 * \*  Time: 10:32
 * \*  Description:
 * \
 */

public class Solution {



    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if(k==0) return res;
        List<Integer> list = new ArrayList<>();
        dfs(n,k,list,1);
        return res;
    }

    private void dfs(int n, int k, List<Integer> list, int begin) {
        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int i = begin;i<=n;++i){
            list.add(i);
            dfs(n,k,list,i+1);
            list.remove(list.size()-1);
        }
    }

}
