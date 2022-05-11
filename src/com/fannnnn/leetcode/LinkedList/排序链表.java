package com.fannnnn.leetcode.LinkedList;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/15
 * \*  Time: 14:46
 * \*  Description:
 * \
 */

public class 排序链表 {

    public ListNode sortList(ListNode head) {
        return sortList(head,null);
    }

    public ListNode sortList(ListNode head,ListNode tail){
        if(head==null) return null;
        if(head.next==tail){
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
        ListNode list1 = sortList(head,mid);
        ListNode list2 = sortList(mid,tail);
        ListNode res = mergeNode(list1,list2);
        return res;
    }

    private ListNode mergeNode(ListNode head1, ListNode head2) {
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while(head1!=null && head2!=null){
            if(head1.val <= head2.val){
                temp.next = head1;
                head1 = head1.next;
            }else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if(head1!=null){
            temp.next = head1;
        }else if(head2!=null){
            temp.next = head2;
        }
        return res.next;
    }
}
