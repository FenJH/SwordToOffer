package com.dugstudio.SwordToOffer;

import org.omg.PortableInterceptor.INACTIVE;

class MyThread extends  Thread{
    public static Integer n=1000;
    @Override
     public  void run(){
        super.run();
        math();
    }
     public synchronized void math(){
        n--;
        System.out.println(n+ "-我是"+Thread.currentThread().getId()+" "+Thread.currentThread().getName()+" "+n);
         if (Thread.currentThread().getId()>900){
             System.out.println(Thread.currentThread().getName()+"--------------------interrupt!!!");
             Thread.currentThread().interrupt();
             System.out.println(Thread.currentThread().getName()+"---"+this.isInterrupted());
         }
    }
    public void math1(){
        n--;
        System.out.println(n+ "-我是"+Thread.currentThread().getName()+" "+n);
    }
    public void math2(){
        synchronized (n){
            n--;
            System.out.println(n+ "-我是"+Thread.currentThread().getName()+" "+n);
        }
    }

}
public class Main {
    public static void main(String[] args) {
       long st=System.currentTimeMillis();
        System.out.println(st);
        MyThread m=new MyThread();
        Thread t;
    for (int i=0;i<1000;i++){
       t=new Thread(m);
       t.start();

    }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.currentThread().interrupt();
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
    }
}
