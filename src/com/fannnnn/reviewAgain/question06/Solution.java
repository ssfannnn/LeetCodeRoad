package com.fannnnn.reviewAgain.question06;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/30
 * \*  Time: 9:22
 * \*  Description:
 * \
 */

public class Solution {

    public String convert(String s, int numRows) {
        if(numRows < 2) return s;  //如果只有一行的话 直接输出s
        StringBuffer[] buffers = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            buffers[i] = new StringBuffer(); //初始化
        }
        int flag = -1; //用来判断此时该+还是-
        int index = 0;
        for(int i = 0;i<s.length();++i){
            buffers[index].append(s.charAt(i));
            if(index==0 || index == numRows-1) flag = -flag; //如果此时在第一行 则往下面的元素加  若此时在最后一行 则往上面的元素加
            index+=flag;
        }
        StringBuffer res = new StringBuffer();
        for (StringBuffer buffer : buffers) {
            res.append(buffer);
        }
        return res.toString();
    }
}
