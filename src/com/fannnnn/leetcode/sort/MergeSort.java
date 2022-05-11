package com.fannnnn.leetcode.sort;

public class MergeSort {

    public static void mergeSort(int[] array,int left,int right,int[] tempArray){
        if(left<right){
            int mid = left + (right-left)/2;
            mergeSort(array,left,mid,tempArray);
            mergeSort(array,mid,right,tempArray);
            sort(array,left,mid,right,tempArray);
        }
    }

    private static void sort(int[] array, int left, int mid, int right, int[] tempArray) {
        int i = left,j = mid+1;
        int index = 0;
        while(i<=mid && j<=right){
            if(array[i]>=array[j]){
                tempArray[index++] = array[i];
                i++;
            }else {
                tempArray[index++] = array[j];
                j++;
            }
            index++;
        }

        if(i<=mid){
            tempArray[index++] = array[i];
        }else if(j<=right){
            tempArray[index++] = array[j];
        }
    }

/*    public static void mergeSort(int[] array,int left,int right,int[] tempArray){
        if (left<right){
            int mid = (left+right)/2;//中间索引
            //向左递归分解
            mergeSort(array,left,mid,tempArray);
            //向右递归分解
            mergeSort(array,mid+1,right,tempArray);
            //合并
            sort(array,left,mid,right,tempArray);
        }
    }

    private static void sort(int[] array,int left,int mid,int right,int[] tempArray){
        int i = left;//初始化i，左边有序子数组的初始索引
        int j = mid+1;//初始化j，右边有序子数组的初始索引
        int index = 0;//用于标识tempArray数组当前所在的下标
        while (i<=mid&&j<=right){//当左右子数组都没完成数据转移时
            if (array[i]<=array[j]){//左边的元素小于右边的元素，将该元素加入到临时数组中,
                // 一直循环直到找到一个元素比右边的大，将转移权交给右边的子数组
                tempArray[index] = array[i];
                i++;//向右移动一位
                index++;
            }else {//右边的元素小于左边的元素，将该元素加入到临时数组中,
                // 一直循环直到找到一个元素比左边的大，将转移权交给左边的子数组
                tempArray[index] = array[j];
                j++;//向右移动一位
                index++;
            }
        }

        while (i<=mid){//说明左边的子数组有剩余元素
            tempArray[index] = array[i];
            i++;
            index++;
        }
        while (j<=right){//说明右边的子数组有剩余元素
            tempArray[index] = array[j];
            j++;
            index++;
        }

        index=0;
        int tempLeft = left;
        while (tempLeft<=right){
            array[tempLeft] = tempArray[index];
            index++;
            tempLeft++;
        }
    }*/
}

