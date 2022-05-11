package com.fannnnn.review.question160;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/24
 * \*  Time: 14:57
 * \*  Description:
 * \
 */

public class ListNode {

    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

class Solution {

    /**
     * 分别定义pa pb，令他们分别指向headA和headB
     * 分别从头结点开始往后走，pa一旦走到链表末尾 就指向headB，pb一旦走到链表末尾，就指向headA
     * 由于两个链表的长度不等，因此当pa走完headA时再去走headB，pb走完headB时再去走headA，他们一定会在某个等重合，便是所求答案
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode pa = headA,pb = headB;
        while (pa!=pb){
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }
}
