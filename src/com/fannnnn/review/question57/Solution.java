package com.fannnnn.review.question57;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static int[][] findContinuousSequence(int target) {
        List<int[]> res  = new ArrayList<>();
        int i = 1,j=2,sum=3;
        while (i<j){
            if(sum==target){
                int[] arr = new int[j-i+1];
                for(int k = i;k<=j;++k){
                    arr[k-i] = k;
                }
                res.add(arr);
            }
            if(sum>=target){ //如果当前sum大于等于target 减去最末尾的小数,最左边往左移
                sum-=i;
                ++i;
            }else{  //如果当前sum小于target 右指针往右移动一位 加到sum
                ++j;
                sum+=j;
            }
        }
        return res.toArray(new int[0][]);
    }


    public static void main(String[] args) {
        System.out.println(findContinuousSequence(9));
    }
}
