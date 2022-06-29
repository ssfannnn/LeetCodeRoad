package com.fannnnn.reviewAgain.question844;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/29
 * \*  Time: 16:25
 * \*  Description:
 * \
 */

public class Solution {
    public boolean backspaceCompare(String s, String t) {
        return buildString(s).equals(buildString(t));
    }

    private String buildString(String str) {
        StringBuffer buffer = new StringBuffer();
        for (char c : str.toCharArray()) {
            if(c!='#'){
                buffer.append(c);
            }else {
                if(buffer.length()>0){
                    buffer.deleteCharAt(buffer.length()-1);
                }
            }
        }
        System.out.println(buffer.toString());
        return buffer.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.backspaceCompare("a#c","b");
    }
}
