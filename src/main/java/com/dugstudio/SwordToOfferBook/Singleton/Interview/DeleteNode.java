package com.dugstudio.SwordToOfferBook.Singleton.Interview;

/**
 * @Author JH
 * @CreateDate 18-6-8
 * @Description 在O（1）时间内删除链表节点
 */
class Node{
    public Integer value;
    public Node next;

    public Node(Integer value) {
        this.value = value;
        this.next = null;
    }
}
public class DeleteNode {
    public void deleteNode(Node head, Node p){
        //当头结点或者待删除的节点为空
        if(p==null||head==null){
            return;
        }
        Node q;
        //若待删除的节点为尾节点
        if (p.next==null){
             q=head;
            while(q!=null){
                if (q.next==p)break;
                q=q.next;
            }
            q.next=null;
            return;
        }
        //将p的下一个节点q的值赋给p，让p指向q的下个节点，删除q
        q=p.next;
        p.value=q.value;
        p.next=q.next;
        q.next=null;

    }
}
