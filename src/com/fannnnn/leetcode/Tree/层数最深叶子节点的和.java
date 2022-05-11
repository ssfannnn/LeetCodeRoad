package com.fannnnn.leetcode.Tree;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/4
 * \*  Time: 8:19
 * \*  Description:
 * \
 */

public class 层数最深叶子节点的和 {


    int ans = 0;
    int maxDepth = -1;
    public int deepestLeavesSum(TreeNode root) {
        calSum(root,0);
        return ans;
    }

    private void calSum(TreeNode root, int depth) {
        if(root==null) return ;
        if(depth > maxDepth){
            maxDepth = depth;
            ans = 0;
        }
        if(depth == maxDepth){
            ans += root.val;
        }
        depth++;
        calSum(root.left,depth);
        calSum(root.right,depth);
    }


}
