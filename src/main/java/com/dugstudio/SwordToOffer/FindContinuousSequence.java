package com.dugstudio.SwordToOffer;

import java.util.ArrayList;

/**
 * @Author JH
 * @CreateDate 18-5-27
 * @Description
 */
public class FindContinuousSequence {
    /**
     * 字符串循环左移（ROL）
     * @param str
     * @param n
     * @return
     */
    public static  String LeftRotateString(String str,int n) {
        if (str==null||str.length()<=0)return "";
        while(n>0){
            String start=str.substring(0,1);
            String end=str.substring(1);
            System.out.println(start);
            System.out.println(end);
            StringBuilder s=new StringBuilder(end);
            s.append(start);
            str=s.toString();
            n--;
        }
        return str;
    }

    /**
     * 找出所有和为S的连续正数序列
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> root=new ArrayList<ArrayList<Integer>>();
        for (int i=1;i<sum;i++){
            int temp=i;
            ArrayList<Integer> child=new ArrayList<Integer>();
            child.add(i);
            for (int j=i+1;temp<sum;j++){
                temp+=j;
                child.add(j);
            }
            if (temp==sum)
                root.add(child);
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(LeftRotateString("",3));
    }

    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        while(num2!=0){
            int temp=num1^num2;
            num2=(num1&num2)<<1;
            num1=temp;
        }
        return num1;
    }
}
