package com.fannnnn.review.question20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/20
 * \*  Time: 9:07
 * \*  Description:
 * \
 */

public class 有效的括号 {
    public boolean isValid(String s) {
        if(s.length()%2==1) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();++i){
            Character c = s.charAt(i);
            //若此时哈希表中包含当前右括号
            if(map.containsKey(c)) {
                //当前的字符是右括号 但是此时栈为空 或者栈顶元素不等于当前右括号对应的value，说明此时括号不能闭合，直接return false
                if(st.isEmpty() || st.peek()!=map.get(c)){
                    return false;
                }
                //不是以上的情况 说明可以闭合 此时弹出栈顶元素
                st.pop();
            }else {
                //压栈
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}
