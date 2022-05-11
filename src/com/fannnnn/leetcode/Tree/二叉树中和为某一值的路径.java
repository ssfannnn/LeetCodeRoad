package com.fannnnn.leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/11
 * \*  Time: 15:01
 * \*  Description:
 * \
 */

public class 二叉树中和为某一值的路径 {

    List<List<Integer>> res;
    List<Integer> list;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        if(root==null || target==0) return res;
        calPath(root,target);
        return res;

    }

    private void calPath(TreeNode root, int target) {
        if(root==null) return ;
        target-=root.val;
        list.add(root.val);
        if(target==0 && root.right==null && root.left==null) {
            res.add(new ArrayList<>(list));
        }
        calPath(root.left,target);
        calPath(root.right,target);
        list.remove(list.size()-1);
    }
}
