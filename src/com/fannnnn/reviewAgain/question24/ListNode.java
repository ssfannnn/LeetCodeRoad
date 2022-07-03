package com.fannnnn.reviewAgain.question24;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/7/3
 * \*  Time: 10:17
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

    /**
     *建立虚拟头结点，每次以虚拟头结点为核进行交换
     * */
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode res = pre;
        while (pre.next!=null && pre.next.next!=null){
            ListNode node1 = pre.next;
            ListNode node2 = pre.next.next;
            pre.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            pre = node1;
        }
        return res.next;
    }
}
