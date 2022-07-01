package com.fannnnn.leetcode.question707;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/7/1
 * \*  Time: 9:00
 * \*  Description:
 * \
 */
class ListNode{
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

public class MyLinkedList {
    int size;
    ListNode head;
    public MyLinkedList() {
        size = 0;
        head = new ListNode();
    }

    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode node = head;
        for(int i = 0;i<=index;++i){ //包含一个虚拟头结点 因此 i<=index
            node = node.next;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size) return ;
        if(index < 0) index = 0;
        size++; //结点数量+1
        ListNode pre = head;
        for(int i = 0;i<index;++i){
            pre = pre.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return ;
        size--; //结点数量-1
        ListNode temp = head;
        for(int i = 0;i<index;++i){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
}
