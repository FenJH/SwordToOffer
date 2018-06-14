package com.dugstudio.practiceBook;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JH
 * @CreateDate 18-6-7
 * @Description 二进制反射格雷码 幂集
 */
public class BRGC {
    private List<String> l1;
    public List<String> BRGC(int n){
        if (n==1){
             l1=new ArrayList<String>();
            l1.add("0");
            l1.add("1");
            return l1;
        }
        else{
            l1=new ArrayList<String>(BRGC(n-1));
            int len=l1.size();
            //将l1每个字符串在前面加上0,在l1的每个字符串前面加上1 将此字符串加入l1
            for (int i=0;i<len;i++){
                String s=l1.get(i);
                String s1="0"+s;
                l1.remove(i);
                l1.add(i,s1);
                String s2="1"+s;
                l1.add(s2);
            }
            //将l1返回
           return l1;

        }
    }

    public static void main(String[] args) {
        BRGC brgc=new BRGC();
        System.out.println(brgc.BRGC(5));
    }
}
