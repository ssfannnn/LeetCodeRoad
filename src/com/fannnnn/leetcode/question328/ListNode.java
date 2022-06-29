package com.fannnnn.leetcode.question328;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/27
 * \*  Time: 8:21
 * \*  Description:
 * \
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}


class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return head;
        ListNode pre = head,next = head.next;
        ListNode node = next;  //记录偶数结点的头节点
        while (next!=null && next.next!=null){
            pre.next = next.next;
            pre = pre.next;
            next.next = pre.next;
            next = next.next;
        }
        pre.next = node;  //链接奇偶两个链表
        return head;
    }
}


