package com.fannnnn.leetcode.Tree;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/4
 * \*  Time: 8:12
 * \*  Description:
 * \
 */

public class 所有大于等于节点的值之和 {

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        //遍历到右子树的最右边
        convertBST(root.right);
        //开始从下往上赋值
        sum += root.val;
        root.val = sum;
        //右子树遍历完 遍历左子树
        convertBST(root.left);
        return root;
    }
}
