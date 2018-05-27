package com.dugstudio.SwordToOffer;

import java.util.Map;

/**
 * @Author JH
 * @CreateDate 18-5-27
 * @Description 连续子数组的最大和
 */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max=array[0];
        int res=array[0];
        for (int i=1;i<array.length;i++){
            max=Math.max(array[i]+max,array[i]);
            res=Math.max(max,res);
        }
        return res;
    }
    public static void main(String[] args) {
        FindGreatestSumOfSubArray f=new FindGreatestSumOfSubArray();
        int []a={6,-3,-2,7,-15,1,2,2};
        System.out.println(f.FindGreatestSumOfSubArray(a));
    }
}
