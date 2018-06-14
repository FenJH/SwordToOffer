package com.dugstudio.SwordToOfferBook.Singleton.Interview;

/**
 * @Author JH
 * @CreateDate 18-6-9
 * @Description
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class Clone {
    public RandomListNode Clone(RandomListNode pHead)
    {   if (pHead==null) return null;
    RandomListNode clone,p=pHead;//当前节点
        int len=0;
        while (p!=null){
            clone=new RandomListNode(p.label);
            clone.next=p.next;
            p.next=clone;
            p=clone.next;
            len++;
        }
        System.out.println("len:"+len);
        p=pHead;
        while (p!=null){
            if (p.random!=null){
                p.next.random=p.random.next;
            }
            p=p.next.next;
        }
        RandomListNode q=pHead;
        RandomListNode h=p=pHead.next;
        for (int i=0;i<len*2-1;i++){
            if ((i&1)==1){
                p.next=p.next.next;
                p=q.next;
            }else{
                q.next=q.next.next;
                q=p.next;
            }
        }
        return h;

    }

    public static void main(String[] args) {
        Clone c=new Clone();
        RandomListNode r1=new RandomListNode(1);
        RandomListNode r2=new RandomListNode(2);
        RandomListNode r3=new RandomListNode(3);
        RandomListNode r4=new RandomListNode(4);
        RandomListNode r5=new RandomListNode(5);
        r1.next=r2;
        r2.next=r3;
        r3.next=r4;
        r4.next=r5;
        r1.random=r3;
        r2.random=r5;
        r4.random=r2;

        RandomListNode p=c.Clone(r1);
        while(p!=null){
            System.out.println(p.label);
            p=p.next;
        }

    }
}
