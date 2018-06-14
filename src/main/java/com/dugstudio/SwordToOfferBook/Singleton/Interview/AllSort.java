package com.dugstudio.SwordToOfferBook.Singleton.Interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author JH
 * @CreateDate 18-6-2
 * @Description
 */
public class AllSort {
    public static boolean isSwap(List<String>list,int st,int en){
        for (int i=st;i<en;i++){
            if (list.get(i).equals(list.get(en))){
                return false;
            }
        }
        return true;
    }
    /**
     * 消除重复的字符串全排列
     * @param args
     */public  static List<List <String>> perm=new ArrayList<List <String>>();//存储所有的排列可能
    public static  int count=0;
    public static void Permutations(List<String> list, int st, int en){
        if (st==en){
            perm.add(new ArrayList<String>(list));
            count++;
        }else{

            for (int i=st;i<en;i++){
                if (isSwap(list,i,en-1)) {
                    Collections.swap(list, st, i);
                    Permutations(list, st + 1, en);
                    Collections.swap(list, st, i);
                }
            }
        }

    }
    public static void main(String[] args) {
//全排列
      /*  String str="121";
        List<String >list=new ArrayList<>();
        for (int i=0;i<str.length();i++){
            list.add(str.charAt(i)+"");
        }
        Permutations(list,0,str.length());
        System.out.println(count);
        for (List<String > s:perm
                ) {
            for (String  s1:s
                 ) {
                System.out.print(s1);
            }
            System.out.println();

        }*/
    }
}
