package com.dugstudio.SwordToOfferBook.Singleton.Interview;

/**
 * @Author JH
 * @CreateDate 18-5-30
 * @Description
 */
public class SpaceReplace {
    public static String replaceSpace(StringBuffer str) {
        if(str==null||str.length()==0)return null;
       String s=str.toString();
        for (;s.contains(" ");){
           s=s.replace(" ","%20");
        }
        return s;
    }

    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(sb) );
    }
}
