package com.dugstudio.SwordToOfferBook.Singleton.Interview;

/**
 * @Author JH
 * @CreateDate 18-6-10
 * @Description
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null)return null;
        ListNode p1=pHead1,p2=pHead2;
        int len1=0,len2=0;
        //计算p1的长度
        while (p1!=null){
            len1++;
            p1=p1.next;
        }
        //计算p2的长度
        while (p2!=null){
            len2++;
            p2=p2.next;
        }
        int i=len1-len2;
        p1=pHead1;
        p2=pHead2;
        //让常德链表先走i步 这样他们就是同步的
        if (i>0){
            while (i>0){
                p1=p1.next;
                i--;
            }

        }else{
            while (i<0){
                p2=p2.next;
                i++;
            }
        }
        //遍历直到两个节点相等
        while (p1!=null||p2!=null){
            if (p1==p2)return p1;
            p1=p1.next;
            p2=p2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        ListNode l6=new ListNode(6);
        ListNode l7=new ListNode(7);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l6;
        l5.next=l6;
        l6.next=l7;
        FindFirstCommonNode f=new FindFirstCommonNode();
        f.FindFirstCommonNode(l1,l5);

    }
}
