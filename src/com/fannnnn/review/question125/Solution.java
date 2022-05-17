package com.fannnnn.review.question125;

import java.util.Locale;

public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null || "".endsWith(s)) return true;
        s = s.toLowerCase();
        System.out.println(s);
        StringBuffer buffer = new StringBuffer();
        for (char c : s.toCharArray()) {
            if((c>='a'&&c<='z') || (c>='0' && c<='9')){
                buffer.append(c);
            }
        }
        String str = buffer.toString();
        if(str==null || "".endsWith(str)) return true;
        System.out.println(str);
        int i = 0,j = str.length()-1;
        while (i<=j){
            System.out.println(str.charAt(i) + " "+str.charAt(j));
            if(str.charAt(i)!=str.charAt(j)) return false;
            ++i;
            --j;
        }
        return true;
    }
}
