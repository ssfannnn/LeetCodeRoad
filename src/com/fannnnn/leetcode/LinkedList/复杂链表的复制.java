package com.fannnnn.leetcode.LinkedList;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/11
 * \*  Time: 15:43
 * \*  Description:
 * \
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class 复杂链表的复制 {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        //复制每个结点并进行链接
        for(Node node = head;node!=null;node = node.next.next){
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }

        //复制random指针
        for(Node node = head;node!=null;node = node.next.next){
            node.next.random = node.random == null ? null :node.random.next;
        }

        //将原有链接和复制链表进行分离
        Node res = head.next;
        for(Node node = head;node!=null;node = node.next){
            Node newNode = node.next;
            node.next = node.next.next;
            newNode.next = newNode.next==null ? null :newNode.next.next;
        }
        return res;
    }
}
