package com.fannnnn.leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/15
 * \*  Time: 10:21
 * \*  Description:
 * \
 */

public class 环形链表2 {

    /**
     * 解法一：哈希表，遍历链表中的结点，只要当前结点已经出现过，就说明它是环的第一个结点，就跳出循环
     * */

    public ListNode2 detectCycle(ListNode2 head) {
        if(head==null) return null;
        Set<ListNode2> set = new HashSet();
        while (!set.contains(head) && head!=null){
            set.add(head);
            head = head.next;
        }
        return head;
    }

    /**
     * 解法二：快慢指针
     * 1.定义fast 和 slow两个指针，指向head，fast一次走两步，slow一次走一步
     * 2.如果有环，fast和slow最终会相遇
     *
     * */


    public ListNode2 detectCycle2(ListNode2 head) {
        if(head==null) return null;
        ListNode2 slow = head,fast = head;
        while (fast!=null){
            slow = slow.next;
            if(fast.next!=null){
                fast = fast.next.next;
            }else {
                return null;
            }
            if(fast==slow){
                ListNode2 pre = head;
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

class ListNode2 {
      int val;
      ListNode2 next;
      ListNode2(int x) {
          val = x;
         next = null;
      }
}
