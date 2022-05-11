package com.fannnnn.leetcode.Stack;

import java.util.Stack;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/11
 * \*  Time: 9:22
 * \*  Description:
 * \
 */

public class 栈的压入弹出序列 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length!=popped.length) return false;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int number : pushed) {
            //将pushed中的元素放入栈中
            stack.push(number);
            //如果栈不为空，且栈顶元素==poped[index]，那么弹出栈顶，并将poped的指针指向下一个元素，用于下一次比较
            while (!stack.isEmpty() && stack.peek() == popped[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
