package com.fannnnn.review.question146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

class DLinkedNode{
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode next;
    public DLinkedNode(){}
    public DLinkedNode(int key,int value){
        this.key = key;
        this.value = value;
    }
}

    int size;
    int capacity;
    Map<Integer,DLinkedNode> map = new HashMap<>();
    DLinkedNode head,tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail; //head和tail为LRU的两端，head和tail不指向任何元素
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if(node==null) return -1;
        moveToHead(node);
        return node.value;

    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if(node==null){
            DLinkedNode newNode = new DLinkedNode(key, value);
            //将node加入缓存
            map.put(key,newNode);
            //将该元素放到队头
            addToHead(newNode);
            //size+1
            size++;
            //如果超过最大容量，将最久未使用的拿出
            if(size>capacity){
                DLinkedNode tail = removeTail();
                map.remove(tail.key);
                --size;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private DLinkedNode removeTail() {
        DLinkedNode pre = tail.pre;
        removeNode(pre);
        return pre;
    }
}
