package com.fannnnn.review.question105;

import java.util.HashMap;
import java.util.Map;

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

class Solution{
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<n;++i){
            map.put(inorder[i],i);
        }
        return myTree(preorder,inorder,0,n-1,0,n-1,map);
    }

    private TreeNode myTree(int[] preorder, int[] inorder,
                            int pre_left, int pre_right, int in_left, int in_right,
                            Map<Integer,Integer> map) {
        if(pre_left>pre_right) return null;
        //找到根节点
        int root_val = preorder[pre_left];
        //构造根节点
        TreeNode root = new TreeNode(root_val);
        //找到根节点在inorder中的位置
        Integer in_root = map.get(root_val);
        //左子树的长度
        int left = in_root-in_left;
        //构建左子树
        root.left = myTree(preorder,inorder,pre_left+1,pre_left+left,in_left,in_root-1,map);
        //构建右子树
        root.right = myTree(preorder,inorder,pre_left+left+1,pre_right,in_root+1,in_right,map);
        return root;
    }
}
