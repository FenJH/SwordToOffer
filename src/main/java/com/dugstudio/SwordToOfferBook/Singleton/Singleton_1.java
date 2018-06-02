package com.dugstudio.SwordToOfferBook.Singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author JH
 * @CreateDate 18-5-30
 * @Description
 */
public class Singleton_1 {
    private static int x;
    private static Singleton_1 singleton_1;

    private Singleton_1() {
        x++;
    }

    public static Singleton_1 getInstance() {
        if (singleton_1 == null) {

            Lock lock = new ReentrantLock();
            try {
                lock.lock();
                if (singleton_1 == null) {
                    singleton_1= new Singleton_1();
                }

            } finally {
                lock.unlock();
            }
        }

        System.out.println(Thread.currentThread().getName()+"--"+x);
        return singleton_1;
    }
}
