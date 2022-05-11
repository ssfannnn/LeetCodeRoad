//package com.fannnnn.leetcode.Tree;
//
//
//import java.util.Deque;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Node {
//    public int val;
//    public Node left;
//    public Node right;
//    public Node next;
//
//    public Node() {}
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, Node _left, Node _right, Node _next) {
//        val = _val;
//        left = _left;
//        right = _right;
//        next = _next;
//    }
//};
//
//
//class Solution {
//
//    /**
//     * 层次遍历即可，注意每一层除了最后一个元素以外 别的元素都指向右边的元素
//     * 由于next原本指向null  因此每层的最后一个元素不需要处理
//     * */
//    public Node connect(Node root) {
//        if(root==null) return root;
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            for(int i = 0;i<size;++i){
//                Node node = queue.poll();
//                if(i<size-1){
//                    node.next = queue.peek();
//                }
//                if(node.left!=null){
//                    queue.add(node.left);
//                }
//                if(node.right!=null){
//                    queue.add(node.right);
//                }
//            }
//        }
//        return root;
//    }
//}
