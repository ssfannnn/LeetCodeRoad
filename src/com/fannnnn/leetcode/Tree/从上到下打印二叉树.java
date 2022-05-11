package com.fannnnn.leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/11
 * \*  Time: 14:20
 * \*  Description:
 * \
 */

public class 从上到下打印二叉树 {


    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            int size =queue.size();
            for(int i = 0;i<size;++i){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null) queue.add(root.left);
                if(node.right!=null) queue.add(root.right);
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        while (!list.isEmpty()){
            res[index++] = list.get(0);
            list.remove(0);
        }
        return res;
    }
}
