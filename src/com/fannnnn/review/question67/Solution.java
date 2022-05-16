package com.fannnnn.review.question67;


import javafx.stage.PopupWindow;

public class Solution {

    /**
     * 二进制计算和 逢二进一
     * */
    public String addBinary(String a, String b) {
        StringBuffer buffer = new StringBuffer();
        int n = Math.max(a.length(),b.length());
        int carry = 0;
        for(int i = 0;i<n;++i){
            carry+=i<a.length()?(a.charAt(a.length()-i-1)-'0') : 0;
            carry+=i<b.length()?(b.charAt(b.length()-i-1)-'0') : 0;
            buffer.append(carry%2);
            carry/=2;
        }
        if(carry>0){
            buffer.append(carry);
        }
        return buffer.reverse().toString();
    }
}
