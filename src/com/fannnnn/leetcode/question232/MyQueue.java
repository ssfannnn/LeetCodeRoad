package com.fannnnn.leetcode.question232;

import java.util.Stack;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/30
 * \*  Time: 8:28
 * \*  Description:
 * \
 */

public class MyQueue {

    Stack<Integer> st1;
    Stack<Integer> st2;
    Integer front;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        this.front = x;
        st1.push(x);
    }

    public int pop() {
        while (!st1.isEmpty()){
            st2.push(st1.pop());
        }
        Integer pop = st2.pop();
        while (!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return pop;
    }

    public int peek() {
        while (!st1.isEmpty()){
            st2.push(st1.pop());
        }
        Integer peek = st2.peek();
        while (!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return peek;
    }

    public boolean empty() {
        return st1.isEmpty();
    }
}
