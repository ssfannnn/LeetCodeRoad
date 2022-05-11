package com.fannnnn.leetcode.LinkedList;

import sun.awt.image.ImageWatched;

import java.beans.beancontext.BeanContext;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/6
 * \*  Time: 14:29
 * \*  Description:
 * \
 */

public class 两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode ansNode = temp;
        while (temp.next!=null && temp.next.next!=null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return ansNode.next;
    }
}
