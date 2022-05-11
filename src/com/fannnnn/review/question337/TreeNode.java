package com.fannnnn.review.question337;

import java.util.HashMap;
import java.util.Map;

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


/**
 * 对于每一个节点 都有取和不取两种状态  如果取了当前结点 那么该结点的左孩子和右孩子则不能被选择
 * 因此设f数组为结点被选中时所能偷到的最大金钱  g数组为当前结点不被选中时偷到的最大金钱
 * 当当前结点被选中时 它的左孩子l和右孩子r不能被选中 因此 f[o] = g[l] + g[r]
 * 当当前结点没有被选中 他的左孩子和有孩子可以都被选中 也可以只选择一个，也可以都不选择
 *  因此g[o] = Math.max(f[l],g[r])+Math.max(f[r],g[l])
 *  展开式为:
 *   g[o] = Math.max(f[l]+f[r],f[l]+g[r],g[l]+f[r],g[l]+g[r]);
 *
 *   采用二叉树的后续遍历 自底向上遍历
 * */
class Solution {
    Map<TreeNode,Integer> f = new HashMap<>();
    Map<TreeNode,Integer> g = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root,0),g.getOrDefault(root,0));
    }

    private void dfs(TreeNode root) {
        if(root==null){
            return ;
        }
        dfs(root.left);
        dfs(root.right);
        f.put(root,root.val+g.getOrDefault(root.left,0) + g.getOrDefault(root.right,0));
        g.put(root,Math.max(f.getOrDefault(root.left,0),g.getOrDefault(root.left,0))
                + Math.max(f.getOrDefault(root.right,0),g.getOrDefault(root.right,0)));
    }
}
