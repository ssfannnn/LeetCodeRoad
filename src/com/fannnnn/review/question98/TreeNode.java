package com.fannnnn.review.question98;

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
     * 二叉树的中序遍历
     * 如果后一个元素小于等于前一个元素 说明不符合BST，反之不然
     * */
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        for(int i = 1;i<list.size();++i){
            if(list.get(i)<=list.get(i-1)) return false;
        }
        return true;
    }

    private void inorder(TreeNode root,List<Integer> list) {
        if(root==null) return ;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);

    }

    long pre = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        if(root==null) return true;

        if(!isValidBST2(root)){
            return false;
        }

        if(root.val<=pre){
            return false;
        }
        pre = root.val;
        isValidBST2(root.left);
        return isValidBST2(root.right);
    }



    }
