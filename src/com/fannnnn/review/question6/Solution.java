package com.fannnnn.review.question6;

import java.util.ArrayList;
import java.util.List;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/11
 * \*  Time: 8:43
 * \*  Description:
 * \
 */

public class Solution {

    /**
     * 字符串z字型变换，对于生成都每一行都使用Stringbuffer来存储
     * 定义一个index下标 flag用来标识是否需要变换加减符号
     * 每次到第0层或最后一层 需要将flag取反
     * 通过index+=flag来获取需要添加字符的的那个stringbuffer在集合中的位置
     * */
    public static String convert(String s, int numRows) {
        if(numRows<2) return s;
        List<StringBuffer> list = new ArrayList<>();
        for(int i = 0;i<numRows;++i){
            list.add(new StringBuffer());
        }
        int flag = -1;
        int index = 0;
        for (char ch : s.toCharArray()) {
            list.get(index).append(ch);
            if(index==0 || index==numRows-1) flag = -flag;
            index+=flag;
        }
        StringBuffer res = new StringBuffer();
        for (StringBuffer buffer : list) {
            res.append(buffer.toString());
        }
        return res.toString();
    }

    public static String convert2(String s, int numRows) {
        if(numRows<2) return s;
        StringBuffer[] buffers = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            buffers[i] = new StringBuffer();
        }
        int flag = -1;
        int index = 0;
        for (char ch : s.toCharArray()) {
           buffers[index].append(ch);
           if(index==0 || index==numRows-1) flag = -flag;
           index+=flag;
        }
        StringBuffer res = new StringBuffer();
        for (StringBuffer buffer : buffers) {
            res.append(buffer.toString());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String res = convert2("PAYPALISHIRING", 4);
        System.out.println(res);
    }
}
