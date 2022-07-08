package com.fannnnn.leetcode.question20;

import java.util.Stack;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/7/8
 * \*  Time: 9:06
 * \*  Description:
 * \
 */

public class Solution {

    /**
     * 当前ch与栈顶元素不匹配 直接return false
     * 遇到右括号时stack为空 直接return false
     *
     * */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch=='(') stack.push(')');
            else if(ch=='[') stack.push(']');
            else if(ch=='{') stack.push('}');
            else if(stack.isEmpty() || stack.peek() != ch) return false;
            else stack.pop();
        }
        return stack.isEmpty();
    }
}
