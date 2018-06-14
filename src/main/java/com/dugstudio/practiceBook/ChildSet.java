package com.dugstudio.practiceBook;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author JH
 * @CreateDate 18-6-6
 * @Description n个元素的幂集
 */
public class ChildSet {
    private static ArrayList<ArrayList<Integer>> childList=new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> childSet(int [] set){
        if (set==null||set.length==0)return null;
        ArrayList <Integer> list=new ArrayList<Integer>();
        childList.add(new ArrayList<Integer>());
        getChild(list,0,set.length,set);
        return childList;
    }
    public void getChild(ArrayList<Integer> list,int st,int en,int[] set ){
        if (st==en)return;
        for (int i=st;i<en;i++){
            list.add(set[i]);
            childList.add(new ArrayList<Integer>(list));
            getChild(list,i+1,en,set);
            list.remove(list.lastIndexOf(set[i]));
        }

    }

    public static void main(String[] args) {
        int[] aa={2,3,5,4,6,4,7,3};
        ChildSet c=new ChildSet();
        c.childSet(aa);
        int count=0;
        for (ArrayList<Integer> l:childList){
            count++;
            System.out.println(l);
        }
        System.out.println("---------"+count);
    }
}
