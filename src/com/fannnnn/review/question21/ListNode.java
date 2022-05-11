package com.fannnnn.review.question21;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/20
 * \*  Time: 9:51
 * \*  Description:
 * \
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

class Solution{
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null) return null;
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        while (list1!=null && list2!=null){
            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        //合并完以后至多只有一个链表未被合并 因此我们只需将指针直接指向不为null的链表即刻
        temp.next = list1==null?list2:list1;
        return res.next;
    }
}
