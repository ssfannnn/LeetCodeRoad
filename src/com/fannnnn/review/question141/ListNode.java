package com.fannnnn.review.question141;



/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/23
 * \*  Time: 9:46
 * \*  Description:
 * \
 */
 class Solution {

     /**
      * 快慢指针 如果有环，由于快指针的速度是满指针速度的两倍 若有环  到最后必然相遇
      * */

    public boolean hasCycle(ListNode head) {
        if(head==null ||head.next==null) return false;
        ListNode slow = head,fast = head.next;
        while (slow!=fast){
            if(fast==null || fast.next==null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}


public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
          val = x;
          next = null;
    }
}
