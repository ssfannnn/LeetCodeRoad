package com.fannnnn.leetcode.Tree;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/21
 * \*  Time: 11:31
 * \*  Description:
 * \
 */

public class 二叉搜索树与双向链表 {

    /**
     * 要将二叉搜索树改为排序后的双向环形链表，由于要排序 因此用到二叉树的中序遍历
     * */
    Node pre,head;
    public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }
        dfs(root);
        head.left = pre; //头结点的左指针指向尾部
        pre.right = head;//尾指针的右指针指向头结点
        return head;
    }

    private void dfs(Node cur) {
        //遍历到根结点 直接return
        if(cur==null) return ;
        //遍历左子树
        dfs(cur.left);
        //若pre为空 说明是最左的结点 将该值设为head
        if(pre==null){
            head = cur;
        }else { // 若不为空
            pre.right = cur;
        }
        //连接left指针
        cur.left = pre;
        //连接right指针
        pre = cur;
        //递归右子树
        dfs(cur.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
