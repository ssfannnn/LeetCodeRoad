package com.fannnnn.leetcode.Tree;

import sun.reflect.generics.tree.Tree;

import javax.xml.ws.soap.Addressing;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/11
 * \*  Time: 14:34
 * \*  Description:
 * \
 */

public class 从上到下打印二叉树3 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>(); //定义为双端列表
            int size = queue.size();
            for(int i = 0;i<size;++i){
                TreeNode node = queue.poll();
                if(res.size()%2==0) list.addLast(node.val);  //如果res中目前为偶数个元素，说明下一行是奇数行，那么就从从左往后输出 因此从队尾插入
                else list.addFirst(node.val); //反之从队头插入
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
