package com.fannnnn.review.offer05;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/7/6
 * \*  Time: 9:37
 * \*  Description:
 * \
 */

public class Solution {

    /**
     *提前扩充字符串长度 ，从后往前遍历填充
     * 如果遇到空格 ，就依次从后往前填充 '0' '2' '%'
     * 如果遇到字符 直接往后插入
     * */
    public String replaceSpace(String s) {
        if(s==null || s.length()==0) return s;
        StringBuffer buffer = new StringBuffer();
        for (char c : s.toCharArray()) {
            if(c==' ') buffer.append(' ').append(' ');
        }
        int left = s.length()-1;
        s += buffer.toString();
        int right = s.length()-1;
        if(left == right) return s;
        char[] chars = s.toCharArray();
        while (left >= 0){
            if(s.charAt(left) != ' '){
                chars[right] = chars[left];
            }else {
                chars[right] = '0';
                chars[--right] = '2';
                chars[--right] = '%';
            }
            left--;
            right--;
        }
        return new String(chars);
    }
}
