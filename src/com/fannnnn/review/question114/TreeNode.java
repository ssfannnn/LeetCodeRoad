package com.fannnnn.review.question114;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 由题意可知 可以利用二叉树的中序遍历先获得二叉树的所有结点
     * 对每个结点进行链接 每个结点的左节点指向null 右节点指向cur
     * */

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root,list);
        for(int i = 1;i<list.size();++i){
            TreeNode pre = list.get(i-1),cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }

    }

    private void inOrder(TreeNode root, List<TreeNode> list) {
        if(root==null) return ;
        list.add(root);
        inOrder(root.left,list);
        inOrder(root.right,list);
    }
}
