package com.fannnnn.reviewAgain.question19;


public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        while (n>0){
            temp = temp.next;
            --n;
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
