package com.fannnnn.review.question394;

import java.util.LinkedList;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/29
 * \*  Time: 8:11
 * \*  Description:
 * \
 */

public class Solution {

    public String decodeString(String s) {
        LinkedList<Integer> mulList = new LinkedList<>();
        LinkedList<String> strList = new LinkedList<>();
        int multi = 0;
        StringBuffer buffer = new StringBuffer();
        for (char ch : s.toCharArray()) {
            if(ch>='0' && ch<='9'){
                multi = multi*10 + Integer.parseInt(String.valueOf(ch));
            }else if(ch>='a' && ch<='z'){
                buffer.append(ch);
            }else if(ch=='['){
                //如果ch为左括号 讲当前数字和拼接起来的字符串都放入集合当中
                mulList.add(multi);
                strList.add(buffer.toString());
                multi = 0;
                buffer = new StringBuffer();
            }else {
                //如果为右括号，取出栈顶的数字 数字是几  buffer拼接几次
                Integer cnt = mulList.removeLast();
                StringBuffer temp = new StringBuffer();
                for(int i = 0;i<cnt;++i){
                    temp.append(buffer);
                }
                //更新buffer
                buffer = new StringBuffer(strList.removeLast() + temp);
            }
        }
        return buffer.toString();
    }
}
