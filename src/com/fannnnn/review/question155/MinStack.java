package com.fannnnn.review.question155;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MinStack {

    Stack<Integer> st1;
    Stack<Integer> st2;

    public MinStack() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int val) {
        st1.push(val);
        if(st2.isEmpty() || st2.peek()>=val){
            st2.push(val);
        }
    }

    public void pop() {
        int pop = st1.pop(); //这里的pop必须是int类型
        if(st2.peek()==pop) {
            st2.pop();
        }
    }

    public int top() {
        return st1.peek();
    }

    public int getMin() {
        return st2.peek();
    }
}
