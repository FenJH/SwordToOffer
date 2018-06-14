package com.dugstudio.SwordToOfferBook.Singleton;

/**
 * @Author JH
 * @CreateDate 18-5-30
 * @Description 静态内部类 实现按需创建
 */
public class Singleton_2 {
    private Singleton_2 (){
        System.out.println("Singleton_2 init");
    }
    public static  Singleton_2 getInstance(){
        return Helper.singleton_2;
    }
    static class Helper{
        private Helper(){
        }
        public  static Singleton_2 singleton_2=new Singleton_2();
    }
}
