package com.fannnnn.leetcode.Tree;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/10
 * \*  Time: 8:54
 * \*  Description:
 * \
 */

public class 路径总和3 {

    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        int ans = searchPath(root,targetSum);
        ans+=searchPath(root.left,targetSum);
        ans+=searchPath(root.right,targetSum);
        return ans;
    }

    private int searchPath(TreeNode root, int targetSum) {
        int ans = 0;
        if(root==null) return 0;
        targetSum-=root.val;
        if(targetSum==0){
            ans++;
        }
        ans+=searchPath(root.left,targetSum);
        ans+=searchPath(root.right,targetSum);
        return ans;
    }
}
