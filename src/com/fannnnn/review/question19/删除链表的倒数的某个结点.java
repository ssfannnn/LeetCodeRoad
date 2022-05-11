package com.fannnnn.review.question19;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/20
 * \*  Time: 8:38
 * \*  Description:
 * \
 */

public class 删除链表的倒数的某个结点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0,head); //定义一个结点 他的下一个结点指向head
        ListNode temp = head;
        while (n>0){
            temp = temp.next;
            --n;
        }
        while (temp!=null){
            temp = temp.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        System.out.println(pre.val);
        ListNode res = pre.next;
        return res;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}
