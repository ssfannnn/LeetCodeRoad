package com.fannnnn.review.question234;

import com.sun.org.apache.xerces.internal.util.SAXLocatorWrapper;

public class ListNode {

    int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    /**
     * 快慢指针 ，翻转前一半的链表，翻转完毕后从中间往两头走，若遇到不等，则说明不是回文链表
     * */
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode slow = head,fast = head;
        ListNode pre = head,next = null;
        while (fast!=null && fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = next;
            next = pre;
        }
        if(fast!=null){ //如果链表的结点数是奇数个 再往后走一个节点
            slow = slow.next;
        }
        while (slow!=null && pre!=null){  //slow往右边走  pre往左边走
            if(slow.val!=pre.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
}
