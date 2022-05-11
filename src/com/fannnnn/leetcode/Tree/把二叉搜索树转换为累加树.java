package com.fannnnn.leetcode.Tree;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/17
 * \*  Time: 15:44
 * \*  Description:
 * \
 */

public class 把二叉搜索树转换为累加树 {

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        addRoot(root);
        return root;
    }

    private void addRoot(TreeNode root) {
        if(root==null) return ;
        addRoot(root.right);
        sum+=root.val;
        root.val = sum;
        addRoot(root.left);
    }
}
