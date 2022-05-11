package com.fannnnn.review.question101;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
      }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root,root); //从树的头节点开始往下递归 分别遍历左子树和右子树
    }

    private boolean check(TreeNode left, TreeNode right) {
        if(left==null && right==null) return true; //如果两个结点都为空 说明左右两树对称
        if(left==null || right==null) return false;//只要其中有一个不为空 说明不对称
        //当前结点相等 且他们的左子树和右子树都对称的情况下 说明该树是左右对称的
        return left.val == right.val && check(left.left,right.right) && check(left.right,right.left);
    }
}
