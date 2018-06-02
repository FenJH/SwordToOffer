package com.dugstudio.test.SwordToOfferBook.Singleton;

import com.dugstudio.SwordToOfferBook.Singleton.Singleton;
import com.dugstudio.SwordToOfferBook.Singleton.Singleton_1;
import com.dugstudio.SwordToOfferBook.Singleton.Singleton_2;

/**
 * @Author JH
 * @CreateDate 18-5-30
 * @Description
 */
class MyThread implements Runnable{

    public void run() {
        //System.out.println(Singleton.getInstance());
        //System.out.println(Singleton_1.getInstance());
        System.out.println(Singleton_2.getInstance());
    }
}
public class SingletonTest {
    public static void main(String[] args) {
        MyThread my=new MyThread();
        for (int i=0;i<10;i++){
            new Thread(my," "+i).start();
        }
    }
}
