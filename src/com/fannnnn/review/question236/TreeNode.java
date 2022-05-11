package com.fannnnn.review.question236;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/25
 * \*  Time: 8:47
 * \*  Description:
 * \
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}

class Solution {

    /*
    * 二叉树的后续遍历
    * 三种情况： p、q分别位于root的两侧，
    *           p=root,q在root的左子树或右子树
    *           q=root,p在root的左子树或右子树
    *
    *自底向上的递归
    *
    * 递归终止条件: 1.root==null  2.root=p 3.root=q. 因此 递归返回的值 一定是null 、 p 、q三者中的一个
    * 如果没有左右孩子 则返回null
    * 如果有左孩子符合要求 右孩子不符合，返回左孩子
    * 反之 返回右孩子
    * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==root || q==root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(root==null && right==null) return null; //如果不存在左右孩子 直接return null
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }
}
