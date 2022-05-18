package com.fannnnn.review.question82;

import java.util.HashMap;
import java.util.Map;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/18
 * \*  Time: 8:30
 * \*  Description:
 * \
 */

public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next!=null && cur.next.next!=null) {
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                while (cur.next!=null && cur.next.val == temp) { //有重复结点 cur向后移
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next; //没有重复结点 cur直接指向下一个位置
            }
        }
        return dummyNode.next;
    }
}
