package com.fannnnn.reviewAgain.question160;

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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode temp1 = headA,temp2 = headB;
        while (temp1!=temp2){
            temp1 = temp1.next==null ? temp2 : temp1.next;
            temp2 = temp2.next==null ? temp1 : temp2.next;
        }
        return temp1;
    }
}
