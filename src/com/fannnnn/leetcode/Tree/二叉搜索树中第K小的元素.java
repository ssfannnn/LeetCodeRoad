package com.fannnnn.leetcode.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
\*  Created with IntelliJ IDEA.
\*  @author shensifan
\*  Date: 2022/4/19
\*  Time: 12:36
\*  Description:
\*/

public class 二叉搜索树中第K小的元素 {

    /**
     * 递归找出所有结点，放入最小堆中
     * */

    PriorityQueue<TreeNode> queue;
    public int kthSmallest(TreeNode root, int k) {
        queue = new PriorityQueue<>((o1, o2) -> o1.val-o2.val);
        searchNode(root);
        int i = 0;
        while(i<k-1){
            queue.remove();
            i++;
        }
        int res = queue.peek().val;
        return res;
    }

    private void searchNode(TreeNode root) {
        if(root==null){
            return ;
        }
        queue.add(root);
        searchNode(root.left);
        searchNode(root.right);
    }



    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            stack.pop();
            --k;
            if(k==0){
                break;
            }
            root = root.right;
        }
        return stack.peek().val;
    }


}
