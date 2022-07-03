package com.fannnnn.reviewAgain.question142;

import javax.net.ssl.SSLContext;

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
     * 快慢指针，慢指针每次走一步，快指针每次走两步，若存在环，到最后两指针必定相遇
     * */
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode slow = head,fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                ListNode node = head;
                while (node!=fast){
                    node = node.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }
}
