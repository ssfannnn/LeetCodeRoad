package com.fannnnn.leetcode.Tree;



/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/4
 * \*  Time: 8:40
 * \*  Description:
 * \
 */

public class 完全二叉树的节点个数 {
    public int countNodes(TreeNode root) {
        TreeNode l = root,r = root;
        int lDepth = 0,rDepth = 0;
        while (l!=null){
            lDepth++;
            l = l.left;
        }
        while (r!=null){
            rDepth++;
            r = r.right;
        }
        if(lDepth == rDepth) return (int) (Math.pow(2,lDepth)-1);
        return 1+countNodes(root.left) + countNodes(root.right);
    }
}
