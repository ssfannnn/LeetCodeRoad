package com.fannnnn.reviewAgain.question26;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/6/29
 * \*  Time: 15:52
 * \*  Description:
 * \
 */

public class Solution {

    /**
     * 思路：
     *  1.B为A的左子树或者右子树
     *  2.遍历A和B，如果遍历到B为null 说明B是A的子树 return true，如果A遍历为到某个结点为null，说明B不是A的子树 return false;
     *
     *  特殊情况判断，B为空 则直接return true
     *
     * */

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!=null && B != null) && (recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if(B==null) return true;  //当B为空 直接return true
        if(A==null || A.val!=B.val) return false;  //若A为空 或者 A B对应的结点不相等 则return false
        return recur(A.left,B.left) && recur(A.right,B.right);  //进入下一层递归
    }
}
