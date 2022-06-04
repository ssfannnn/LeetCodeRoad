package com.fannnnn.leetcode.question107;



import org.ietf.jgss.Oid;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/4
 * \*  Time: 10:23
 * \*  Description:
 * \
 */

public class Solution {


    /**
     * 层序遍历完整个数以后 对最后的结果进行倒序输出
     * */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> temp = new ArrayList<>();
        if(root==null) return temp;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            for(int i = 0;i<size;++i){
                TreeNode poll = deque.poll();
                list.add(poll.val);
                if(poll.left!=null) deque.add(poll.left);
                if(poll.right!=null) deque.add(poll.right);
            }
            temp.add(list);
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!temp.isEmpty()){
            res.add(temp.get(temp.size()-1));
            temp.remove(temp.size()-1);
        }
        return res;
    }


    /**
     * 最终的结果用LinkList去存储 没遍历完一层就将该层加入链表的头部
     * */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            for(int i = 0;i<size;++i){
                TreeNode poll = deque.poll();
                list.add(poll.val);
                if(poll.left!=null) deque.add(poll.left);
                if(poll.right!=null) deque.add(poll.right);
            }
            res.add(0,list);
        }
        return res;
    }
}
