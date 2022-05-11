package com.fannnnn.leetcode.Tree;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/17
 * \*  Time: 17:52
 * \*  Description:
 * \
 */

public class 合并二叉树 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null) return root2;
        if(root2==null) return root1;
        TreeNode newTree = new TreeNode(root1.val + root2.val);
        newTree.left = mergeTrees(root1.left,root2.left);
        newTree.right = mergeTrees(root1.right,root2.right);
        return newTree;
    }
}
