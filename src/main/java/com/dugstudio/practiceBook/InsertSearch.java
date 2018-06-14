package com.dugstudio.practiceBook;

import java.util.Arrays;

/**
 * @Author JH
 * @CreateDate 18-6-11
 * @Description 插值查找
 */
public class InsertSearch {
    /**
     *
     * @param array 待查找的数组
     * @param n 查找的值
     * @param left 左边界
     * @param right 右边界
     * @return  两点式：(x-x1)/(x2-x1)=(y-y1)/(y2-y1)
     */
    public int search(int [] array,int n,int left,int right){
        while(left<right){
            int mid=(n-array[left])/(array[right]-array[left])*(right-left)+left;
            if (n==array[mid]){
                return mid;
            }else if (n<array[mid]){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        InsertSearch i=new InsertSearch();
        int [] a={2,4,6,8,54,99,23,8,1,11,0};
        Arrays.sort(a);
        System.out.println(i.search(a,8,0,a.length-1) );
    }
}
