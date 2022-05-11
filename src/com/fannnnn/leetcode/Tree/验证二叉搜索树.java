package com.fannnnn.leetcode.Tree;

import java.text.DateFormatSymbols;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/7
 * \*  Time: 20:27
 * \*  Description:
 * \
 */

public class 验证二叉搜索树 {

    /**
     * 验证二叉搜索树  首先要知道什么是二叉搜索树 定义：二叉搜索树是所有子树的 左节点的值小于父节点 右结点的值大于父节点
     * 因此可以一个节点一个节点来验证 ，如：
     * 若当前结点是某个结点的左节点 那么这个结点的范围必定在    min < root.val < 父节点的值
     * 若当前结点是某个结点的右结点 那么这个结点的范围必定在    父节点的值 < root.val < max
     * max 与 min的值是根据当前结点的值在不断变化的
     * */

    public boolean isValidBST(TreeNode root) {
        return dfs(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }
    private boolean dfs(TreeNode root, Long maxValue, Long minValue) {
        if(root==null) return true;
        if(root.val >= maxValue || root.val <= minValue) return false;
        return dfs(root.left, (long) root.val,minValue) && dfs(root.right,maxValue, (long) root.val);
    }
}
