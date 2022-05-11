package com.fannnnn.leetcode.Exciting;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/17
 * \*  Time: 10:27
 * \*  Description:
 * \
 */

public class 字符串解码 {

    public String decodeString(String s) {

        LinkedList<Integer> mulList = new LinkedList<>();
        LinkedList<String> strList = new LinkedList<>();
        StringBuffer buffer = new StringBuffer();
        int multi = 0;
        for (Character ch : s.toCharArray()) {
            if(ch=='['){
                mulList.addLast(multi);
                strList.addLast(buffer.toString());
                multi = 0;
                buffer = new StringBuffer();
            }
            else if(ch==']'){
                StringBuffer temp = new StringBuffer();
                Integer mul = mulList.removeLast();
                for (int i = 0; i < mul; i++) {
                    temp.append(buffer);
                }
                buffer = new StringBuffer(strList.removeLast() + temp);
            }
            else if(ch>='0' && ch<='9'){
                multi = multi*10+Integer.valueOf(Character.toString(ch));
            }
            else buffer.append(ch);
        }
        return buffer.toString();
    }

}
