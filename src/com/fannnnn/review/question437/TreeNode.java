package com.fannnnn.review.question437;

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
     *
     * 找到每一种路径，从每一个节点开始向下寻找，找到所有符合要求的路径
     *
     */
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        int res = dfs(root,targetSum);
        res+=pathSum(root.left,targetSum);
        res+=pathSum(root.right,targetSum);
        return res;
    }

    private int dfs(TreeNode root, int targetSum) {
        if(root==null) return 0;
        int ans = 0;
        int val = root.val;
        if(val == targetSum){
            ans++;
        }
        ans+=dfs(root.left,targetSum-val);
        ans+=dfs(root.right,targetSum-val);
        return ans;
    }


}
