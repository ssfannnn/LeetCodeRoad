package com.fannnnn.leetcode.Tree;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/17
 * \*  Time: 15:49
 * \*  Description:
 * \
 */

public class 二叉树的直径 {

    int res ;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        dfs(root);
        return res;
    }
    private int dfs(TreeNode root) {
        if(root==null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res,left+right+1);
        return Math.max(left,right)+1;
    }


}
