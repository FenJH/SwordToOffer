package com.dugstudio.ThinkInJava;

import com.dugstudio.SwordToOfferBook.Singleton.Interview.InnerInterface;
/**
 * @Author JH
 * @CreateDate 18-6-3
 * @Description
 */
 class Outer {
     private Inner inner=new Inner();
    public Outer() {
        System.out.println("out init ");
    }
   public void f1(Inner inner){
       System.out.println("outer inner");
        this.inner=inner;
   }
    class Inner{
        public Inner() {

            System.out.println("inner outer init");
        }
    }
}
class Oth extends Outer{
        public Oth() {
            f1(new Inner());
            System.out.println("oth init");
        }
        class Inner extends Outer.Inner{
            public Inner() {
                super();
                System.out.println("oth inner");

            }
        }

    public static void main(String[] args) {

        System.out.println("----------");
        Oth oth=new Oth();
        Inner i=oth.new Inner();
    }
    }
