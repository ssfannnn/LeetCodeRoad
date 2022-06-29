package com.fannnnn.reviewAgain.question104;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/20
 * \*  Time: 9:26
 * \*  Description:
 * \
 */

public class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
    }


}
