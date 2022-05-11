package com.fannnnn.leetcode.Tree;

import java.lang.reflect.Array;
import java.util.*;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/6
 * \*  Time: 14:05
 * \*  Description:
 * \
 */

public class 二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size =deque.size();
            for(int i = 0;i<size;++i){
                TreeNode node = deque.poll();
                list.add(node.val);
                if(node.left!=null) deque.add(node.left);
                if(node.right!=null) deque.add(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
