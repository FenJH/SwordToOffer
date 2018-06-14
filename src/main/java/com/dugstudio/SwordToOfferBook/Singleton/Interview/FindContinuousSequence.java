package com.dugstudio.SwordToOfferBook.Singleton.Interview;

import java.util.ArrayList;

/**
 * @Author JH
 * @CreateDate 18-6-14
 * @Description
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        if(sum<3)return list;
        Integer st=1,ed=2,av=3;
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(st);
        l.add(ed);
        int ax=(1+sum)/2;
        while(st<ax&&ed<sum){
            if (av<sum){
                ed++;
                av+=ed;
                l.add(ed);
            }else if (av>sum){
                if (l.remove(st)) {
                    av-=st++;
                }
            }else {
                list.add(new ArrayList<Integer>(l));
                l.remove(st);
                av-=st++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        FindContinuousSequence f=new FindContinuousSequence();
        System.out.println(f.FindContinuousSequence(15));
    }
}
