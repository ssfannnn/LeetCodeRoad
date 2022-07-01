package com.fannnnn.leetcode.question206;

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = head;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
