package com.fannnnn.review.question92;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/13
 * \*  Time: 8:34
 * \*  Description:
 * \
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right) return head;
        //设置dummyNode，因为有可能从第一个位置开始就翻转了，这种情况不能直接return head，所以这里创建一个dummyNode令其指向第一个结点，总而言之一句话，head的位置是会发生改变的
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for(int i = 0;i<left-1;++i){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for(int i = 0;i<right-left;++i){
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
