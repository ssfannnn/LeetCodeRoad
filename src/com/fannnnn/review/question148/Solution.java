package com.fannnnn.review.question148;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/23
 * \*  Time: 11:26
 * \*  Description:
 * \
 */

public class Solution {

    public ListNode sortList(ListNode head) {
        return sortList(head,null);
    }

    private ListNode sortList(ListNode head,ListNode tail){
        if(head==null) {
            return head;
        }
        if(head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head,fast = head;
        while (fast!=tail){
            slow = slow.next;
            fast = fast.next;
            if(fast!=tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode leftList = sortList(head,mid);
        ListNode rightList = sortList(mid,tail);
        ListNode res = mergeList(leftList,rightList);
        return res;
    }

    private ListNode mergeList(ListNode leftList, ListNode rightList) {
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while (leftList!=null && rightList!=null){
            if(leftList.val <= rightList.val){
                temp.next = leftList;
                leftList = leftList.next;
            }else {
                temp.next = rightList;
                rightList = rightList.next;
            }
            temp = temp.next;
        }
        if(leftList!=null){
            temp.next = leftList;
        }
        if(rightList!=null){
            temp.next = rightList;
        }
        return res.next;
    }
}

class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
