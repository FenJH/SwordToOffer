package com.dugstudio.SwordToOfferBook.Singleton;

/**
 * @Author JH
 * @CreateDate 18-5-30
 * @Description 使用static修饰 静态构造函数 保证只调用一次
 */
public class Singleton {
    private static  int x;
    private Singleton(){
        x++;
    }
    private static Singleton singleton=new Singleton();
    public static Singleton getInstance(){
        System.out.println(Thread.currentThread().getName()+"---"+x);
        return singleton;
    }

}
