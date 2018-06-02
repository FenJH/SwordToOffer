package com.dugstudio.SwordToOfferBook.Singleton.Interview;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author JH
 * @CreateDate 18-5-30
 * @Description 输入一个链表，从尾到头打印链表每个节点的值。输入一个链表，从尾到头打印链表每个节点的值。
 */
 class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
public class printListFromTailToHead {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer>list=new ArrayList<Integer>();
        if (listNode==null)return list;
        Stack<ListNode> stack=new Stack<ListNode>();
        while(listNode!=null){
            stack.push(listNode);
            listNode=listNode.next;
        }
        while(!stack.empty())list.add(stack.pop().val);
        return list;
    }
    public static ArrayList<Integer>l;
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        l=new ArrayList<Integer>();
        if(listNode==null) return l;
        printListFromTailToHeadByCrusive(listNode);
        l.add(listNode.val);
        return l;
    }
    public static void printListFromTailToHeadByCrusive(ListNode listNode) {
        if (listNode.next!=null){
            printListFromTailToHeadByCrusive(listNode.next);
            l.add(listNode.next.val);
        }

    }
    public static void main(String[] args) {
        ListNode l1=new ListNode(67);
        ListNode l2=new ListNode(0);
        ListNode l3=new ListNode(24);
        ListNode l4=new ListNode(58);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        //System.out.println(printListFromTailToHead(l1));
        printListFromTailToHead1(l1);
        System.out.println(l);
    }
}
