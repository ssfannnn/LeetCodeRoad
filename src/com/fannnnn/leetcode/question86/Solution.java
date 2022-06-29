package com.fannnnn.leetcode.question86;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/28
 * \*  Time: 8:34
 * \*  Description:
 * \
 */

public class Solution {


    /**
     * 维护两个链表{
     *     小于x
     *     大于等于x
     * }
     * 最后将小于x的链表的尾指针指向大于等于x的头指针
     * */
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode newSmall = small;
        ListNode newLarge = large;
        ListNode node = head;
        while (node!=null){
            if(node.val < x) {
                small.next = node;
                small = small.next;
            }else  {
                large.next = node;
                large = large.next;
            }
            node = node.next;
        }
        large.next = null;
        small.next = newLarge.next;
        return newSmall.next;
    }
}
