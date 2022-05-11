package com.fannnnn.leetcode.Tree;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;

/**
\*  Created with IntelliJ IDEA.
\*  @author shensifan
\*  Date: 2022/4/19
\*  Time: 11:21
\*  Description:
\*/

public class 求根节点到叶节点数字之和 {


    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    private int dfs(TreeNode root, int sum) {
        if(root==null) return 0;
        sum = sum*10+root.val;
        if(root.left==null &&root.right==null){
            return sum;
        }
        return dfs(root.left,sum) + dfs(root.right,sum);
    }


}
