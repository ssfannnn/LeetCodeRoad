package com.fannnnn.leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/6
 * \*  Time: 8:45
 * \*  Description:
 * \
 */

public class 括号生成 {

    /**
     *
     * */

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n==0) return res;
        dfs(res,n,n,"");
        return res;
    }

    public void dfs(List<String> res, int left,int right , String str) {
        if(left==0 && right==0){
            res.add(str);
            return;
        }
        if(left > right) return;
        if(left > 0){
            dfs(res,left-1,right,str+='(');
        }
        if(right > 0){
            dfs(res,left,right-1,str+=')');
        }
    }
}
