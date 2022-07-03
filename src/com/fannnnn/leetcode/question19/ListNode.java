package com.fannnnn.leetcode.question19;

import java.time.temporal.Temporal;

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
     * 尤其要考虑链表只有一个元素的情况 因此需要使用虚拟头结点，当只有一个元素时，不对链表做任何的操作1011
     * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        while (n-- > 0){
            temp = temp.next;
        }
        ListNode node = new ListNode(0,head);
        ListNode res = node;
        while (temp!=null){
            temp = temp.next;
            node = node.next;
        }
        node.next = node.next.next;
        return res.next;
    }
}
