package com.dugstudio.SwordToOffer;
class myRun implements  Runnable {

    public static int sum=0;
    public void run() {
        for(int i=0;i<100;i++)
        add(1);
        print();
    }
    public   void add(int i){
        sum+=i;
    }
    public  void print(){
        System.out.println(Thread.currentThread().getName()+" "+sum);
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException {
       /*System.out.println(Thread.currentThread().getState());
        Thread a=new Thread();
        System.out.println(a.getState());*/
        ThreadLocal<Thread>t=new ThreadLocal<Thread>();
         /*
        t.set(100);
        System.out.println(t.get());*/
        myRun m=new myRun();
        for (int i=0;i<10;i++){
            Thread t1=new Thread(m," "+i);
            t.set(t1);
            t1.start();
        /*   System.out.println(Thread.currentThread().getName()+" ");
           m.print();*/
        }
        Thread.sleep(1000);
        m.print();
    }

}
