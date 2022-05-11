package com.fannnnn.leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/8
 * \*  Time: 11:46
 * \*  Description:
 * \
 */

public class 二叉树展开为链表 {

    /**
     * 由题意可知实际上展开成链表形式的顺序是一个二叉树的先序遍历,因此我们可对二叉树进行先序遍历 获取所有结点的值并放入list
     * 之后从头结点开始，left指向null  right指向下一个结点
     * */

    public void flatten(TreeNode root) {
        if(root==null) return;
        List<TreeNode> list = new ArrayList<>();
        TreeNode node = root;
        preOrder(node,list);
        TreeNode temp = root;
        list.remove(0);
        while (!list.isEmpty()){
            temp.left = null;
            temp.right = new TreeNode(list.get(0).val);
            list.remove(0);
            temp = temp.right;
        }
    }

    private void preOrder(TreeNode root, List<TreeNode> list) {
        if(root==null) return;
        list.add(root);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }


}
