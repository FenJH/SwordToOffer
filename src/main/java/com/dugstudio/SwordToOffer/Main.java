package com.dugstudio.SwordToOffer;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getState());
        Thread a=new Thread();
        System.out.println(a.getState());
    }
}
