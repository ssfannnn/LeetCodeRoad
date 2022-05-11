package com.fannnnn.review.question142;

import com.sun.org.apache.xerces.internal.util.SAXLocatorWrapper;
import com.sun.xml.internal.bind.v2.util.FatalAdapter;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
          val = x;
          next = null;
    }
}

class Solution{
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode slow = head,fast = head;
        while (fast!=null){
            slow = slow.next;
            if(fast.next!=null){ //如果快指针的下一个结点指向null 说明不存在环
                fast = fast.next.next;
            }else {
                return null;
            }
            if(slow==fast){  //在快慢两个指针相遇时，定义一个指向head的指针pre，与slow同时移动，最终他们会在入环点上相遇
                ListNode pre = head;
                while (pre!=slow){
                    pre = pre.next;
                    slow = slow.next;
                }
                return pre;
            }
        }
        return null;
    }
}
