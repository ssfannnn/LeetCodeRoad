package com.fannnnn.review.question61;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/16
 * \*  Time: 8:24
 * \*  Description:
 * \
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {this.val = val;}
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}

class Solution {

    /**
     * 1.连接首尾 使链表形成一个闭环
     * 2.找到新链表的头结点
     * 3.将新链表的尾结点指向null
     * */

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0 || head.next==null) return head;
        int len = 1;
        ListNode temp = head;
        while (temp.next!=null){
            temp = temp.next;
            len++;
        }
        int step = len - k%len;
        if(step==len) return head;
        temp.next = head;
        while (step>0){
            temp = temp.next;
            step--;
        }
        ListNode newHead = temp.next;
        temp.next = null;
        return newHead;
    }
}
