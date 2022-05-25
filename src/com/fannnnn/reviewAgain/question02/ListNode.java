package com.fannnnn.reviewAgain.question02;

import com.sun.org.apache.bcel.internal.generic.L2D;

import javax.xml.bind.ValidationException;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/23
 * \*  Time: 9:31
 * \*  Description:
 * \
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode node = res;
        while (l1!=null || l2!=null){
            int n1 = l1==null? 0 :l1.val;
            int n2 = l2==null? 0 :l2.val;
            int sum = n1 + n2 + carry;
            carry = sum/10;
            sum%=10;
            res.next = new ListNode(sum);
            res = res.next;
            if(l1!=null) l1 = l1.next;
            if(l2 !=null) l2 = l2.next;
        }
        if(carry>0){
            res.next = new ListNode(carry);
        }
        return node.next;
    }
}
