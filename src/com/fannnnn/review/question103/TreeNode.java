package com.fannnnn.review.question103;

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
      }
}

class Solution {

    /**
     * 二叉树层序遍历的变种
     * */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int flag = 1;
        while (!queue.isEmpty()){
            Deque<Integer> deque = new LinkedList<>();
            int size = queue.size();
            for(int i = 0;i<size;++i){
                TreeNode poll = queue.poll();
                if(flag==1){  //如果是从左往右 则从后端插入
                    deque.addLast(poll.val);
                }else {    //如果是从右往左 则从前端插入
                    deque.addFirst(poll.val);
                }
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
            }
            res.add(new ArrayList<>(deque));
            flag = -flag;  //这一步是关键 切换每一层的遍历方向
        }
        return res;
    }
}
