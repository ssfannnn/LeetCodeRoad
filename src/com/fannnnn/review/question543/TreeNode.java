package com.fannnnn.review.question543;

import java.text.DateFormatSymbols;

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

    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        dfs(root);
        return res-1;
    }
    private int dfs(TreeNode root) {
        if(root==null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res,left+right+1);
        return Math.max(left,right)+1;
    }

}
