package com.fannnnn.leetcode.Exciting;

import sun.security.krb5.internal.crypto.HmacSha1Aes128CksumType;

import java.io.PipedReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PrimitiveIterator;
import java.util.Set;

public class LRUCache {

class DLinkedNode{
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;
    public DLinkedNode(){}
    public DLinkedNode(int key,int value){
        this.key = key;
        this.value = value;
    }
}

    Map<Integer,DLinkedNode> map = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity){
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        DLinkedNode node = map.get(key);
        if(node==null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key,int value){
        DLinkedNode node = map.get(key);
        if(node!=null){ //如果node已经存在
            //修改node的value
            node.value = value;
            //将其移动到表头
            moveToHead(node);
        }else { //不如不存在
            //新建一个node
            DLinkedNode newNode = new DLinkedNode(key, value);
            //放入哈希表中
            map.put(key,newNode);
            //放入队头
            addToHead(newNode);
            //数量+1
            size+=1;
            if(size > capacity){ //如果超过最大容量，将表尾的元素移除
                DLinkedNode tail = removeTail();
                map.remove(tail.key);
                size-=1;
            }
        }
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void addToHead(DLinkedNode newNode) {
        newNode.prev = head;
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


}
