package com.fannnnn.leetcode.TwoPointer;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/4/10
 * \*  Time: 10:13
 * \*  Description:
 * \
 */

public class 回文子串 {

    /**
     * 1.某一个位置开始向两边发散,定义两个指针i,j,分别往字符串两边走,如果str[i]==str[j] 那么res+1
     * 2.由于字符串的长度可能是奇数也可能是 偶数，因此需要考虑两种情况，中心点是一个还是两个，我们需要将两个中心点的情况相加，才能得到最终的答案
     * 比如 s = "abaaab; 中心点只有一个时，从第一个字符开始,a，此时a==a ，所以res+1；
     *                                  接着向两边走，由于i-- < 0，因此跳出循环
     *                                  第二个字符: b== b 此时res+1,接着发散 aba 因为两边指针指向的都是a ，因此res+1 依次类推
     *
     *                   中心点有两个时， 第一次 "ab" s[i]!=s[j]
     *                                  第二次"bd" s[i]!=s[j]
     *                                  第三次"aa" s[i]==s[j]，因此res+1 - > 指针往两边走  baaa,b!=a因此跳出循环 ，进行再下两个字符的判断 以此类推
     * */

    public int countSubstrings(String s) {
        int ans = 0;
        for(int i = 0;i<s.length();++i){
            ans+=calPalindrome(s,i,i);
        }
        for(int i = 0;i<s.length()-1;++i){
            ans+=calPalindrome(s,i,i+1);
        }
        return ans;
    }

    public int calPalindrome(String s,int i,int j){
        int count = 0;
        while (i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            count++;
            i--;
            j++;
        }
        return count;
    }
}
