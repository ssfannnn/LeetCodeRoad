package com.fannnnn.reviewAgain.question203;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/7/1
 * \*  Time: 8:49
 * \*  Description:
 * \
 */

public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode node = pre;
        while (pre.next!=null){
            if(pre.next.val == val){
                pre.next = pre.next.next;
            }else{
                pre = pre.next;
            }
        }
        return node.next;
    }
}
