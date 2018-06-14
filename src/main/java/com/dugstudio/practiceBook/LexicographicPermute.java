package com.dugstudio.practiceBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author JH
 * @CreateDate 18-6-7
 * @Description 字典序的全排列
 */
public class LexicographicPermute {
    private static List<List<Integer>> all=new ArrayList<List<Integer>>();
    public void LexicographicPermute(int n) {
        List<Integer> list = new ArrayList<Integer>();
        //初始化列表
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        //将列表加入all
        all.add(new ArrayList<Integer>(list));
        for (int i=n-1;i>0;i--){
            //寻找两个相邻的连续升序的元素
            if (list.get(i - 1) < list.get(i)) {
                fun(list, n);
                //列表list进行了变换将i重置
                i=n;
            }
        }
    }
 public void fun(List<Integer>list,int n){
        //index_1第一个使第i个元素小于第i+1个元素的下标i
     //index_2在i+1到n之间最小的大于第i个元素的元素min下标
     int index_1=n-1,index_2=n-1,min=Integer.MAX_VALUE;
     boolean flag = false;//标志list没有递减的两个相邻元素就直接返回
     for (int i = n - 1; i > 0; i--) {
         //找到第i个元素小于第i+1个元素的下标赋给index_1
         if (list.get(i - 1) > list.get(i)) ;
         else {
             flag = true;
             index_1 = i - 1;
             break;
         }
     }
     if (!flag) {
         return;
     }
     //在i+1至n中找到最小的大于第i个元素的下标赋给index_2，该值赋值给min
     for (int i = n - 1; i > index_1; i--) {
         if (list.get(i) > list.get(index_1) && min > list.get(i)) {
             index_2 = i;
             min = list.get(i);
         }
     }
     //交换index_1 index_2
     Collections.swap(list, index_1, index_2);
     //将i后面的数字串倒置
     String s = list.subList(index_1 + 1, list.size()).toString();
     StringBuilder sb = new StringBuilder(s);
     s = sb.reverse().toString();
     int k = 1;
     for (int i = index_1 + 1; k < s.length() - 1; ) {
         if (s.charAt(k) >= '0' && s.charAt(k) <= '9')
             list.set(i++, Integer.parseInt(s.charAt(k) + ""));
         k++;
     }
     //将变换后的列表添加到all
     all.add(new ArrayList<Integer>(list));
 }
    public static void main(String[] args) {
        LexicographicPermute l=new LexicographicPermute();
        l.LexicographicPermute(3);
        int count=0;
        for (List<Integer> ll:all
             ) {
            count++;
            System.out.println(ll);
        }
        System.out.println("----------"+count);
    }
}
