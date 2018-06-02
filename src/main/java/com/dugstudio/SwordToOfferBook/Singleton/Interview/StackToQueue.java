package com.dugstudio.SwordToOfferBook.Singleton.Interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author JH
 * @CreateDate 18-6-1
 * @Description 两个队列实现栈
 */
public class StackToQueue {
    private Queue<Integer> queue1=new LinkedList<Integer>();
    private Queue<Integer> queue2=new LinkedList<Integer>();
    //任意时刻只有一个队列里面有元素
    //任意一个队列里面有元素就向其中加入新元素
    public void push(int node){
        if(queue1.isEmpty())
            queue2.add(node);
        else queue1.add(node);
    }
    public int pop() {//将一个队列中的除了末尾元素全部移入另一个队列 队尾元素即为出栈元素
        if (queue1.size() > 0) {
            while (!queue1.isEmpty()) {
                if (queue1.size() == 1) return queue1.remove();
                queue2.add(queue1.remove());
            }
        } else {
            while (!queue2.isEmpty()) {
                if (queue2.size() == 1) return queue2.remove();
                queue1.add(queue2.remove());
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StackToQueue s=new StackToQueue();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
