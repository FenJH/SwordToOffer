package com.dugstudio.SwordToOffer;

import jdk.nashorn.internal.ir.IdentNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {

    public class Solution {
        public String PrintMinNumber(int [] numbers) {
            int len=numbers.length;
            List<Integer > list=new ArrayList<Integer>();
            int min=Integer.MAX_VALUE;
            int x;
            for (int i=0;i<len;i++){
                list.add(numbers[i]);
            }
            Collections.sort(list, new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    String s1=o1+""+o2;
                    String s2=o2+""+o1;
                    return s1.compareTo(s2);
                }
            });
            String s="";
            for (int i:list){
                s+=i;
            }
            return s;
            }
        }
}
