package com.dugstudio.SwordToOfferBook.Singleton.Interview;

import java.util.Stack;

/**
 * @Author JH
 * @CreateDate 18-6-9
 * @Description
 */
public class MinStack <E extends Integer>{
    private Stack<E> minStack=new Stack<E>();
    private Stack<E> element=new Stack<E>();
    public E min(){
        if (!minStack.isEmpty())
        return minStack.peek();
        return null;
    }
    public void push(E e){
        element.push(e);
        if (!minStack.isEmpty()){
           E min=minStack.peek();
           if (e.compareTo(min)<0){
               minStack.push(e);
           }else{
               minStack.push(min);
           }
         }else{
            minStack.push(e);
        }
    }
    public E pop(){
        if (!element.isEmpty()){
            minStack.pop();
            return element.pop();
        }
        return null;
    }
    public  void print(){
        while (!element.isEmpty()){
            System.out.print(element.pop()+"  ");
        }
    }
    public static void main(String[] args) {
        MinStack<Integer> s=new MinStack<Integer>();
        s.push(3);
        System.out.println(s.min());
        s.push(4);
        System.out.println(s.min());
        s.push(2);
        System.out.println(s.min());
        s.push(3);
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        s.push(0);
        System.out.println(s.min());
        System.out.println(s.minStack.size());
    }
}
