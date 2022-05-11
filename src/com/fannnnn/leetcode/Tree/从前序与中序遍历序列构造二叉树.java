package com.fannnnn.leetcode.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/14
 * \*  Time: 15:51
 * \*  Description:
 * \
 */

public class 从前序与中序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<n;++i){
            map.put(inorder[i],i);
        }
        return myTree(preorder,inorder,0,n-1,0,n-1,map);
    }

    private TreeNode myTree(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right,Map<Integer,Integer> map) {
        if(pre_left > pre_right){
            return null;
        }
        //找到根节点
        int pre_root = pre_left;

        //在中序遍历中找到根节点的位置
        int in_root = map.get(preorder[pre_root]);

        //把根节点构建出来
        TreeNode root = new TreeNode(preorder[pre_root]);

        //得到左子树的结点数目
        int leftSize = in_root - in_left;

        //递归构建左子树
        root.left = myTree(preorder,inorder,pre_left+1,pre_left+leftSize,in_left,in_root-1,map);

        //递归构建右子树
        root.right = myTree(preorder,inorder,pre_left+leftSize+1,pre_right,in_root+1,in_right,map);
        return root;
    }
}
