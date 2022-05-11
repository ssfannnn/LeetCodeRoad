package com.fannnnn.leetcode.Tree;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/10
 * \*  Time: 9:09
 * \*  Description:
 * \
 */

public class 找树左下角的值 {

    /**
     * ①从头结点出发，先对左子树进行递归，再对右子树进行递归，一旦root==null，直接return
     * ②需要一个记录当前最大深度的全局变量，若当前深度大于最大深度，那么将最大深度调整为当前深度，且最左侧的子节点赋为当前值。
     * ③继续向下递归
     *
     * */

    int depth = 0,ans = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,1);
        return ans;
    }

    private void dfs(TreeNode root, int deep) {
        if(root==null) return ;
        if(deep > depth){
            depth = deep;
            ans = root.val;
        }
        dfs(root.left,deep+1);
        dfs(root.right,deep+1);
    }
}
