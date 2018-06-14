package com.dugstudio.SwordToOfferBook.Singleton.Interview;

/**
 * @Author JH
 * @CreateDate 18-6-8
 * @Description 反转链表
 */
 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class ReverseList {
    public Node ReverseList(Node head){
        Node h ,p,q,hn;//h当前节点的上一个节点 p当前节点 p的下一个节点 hn保存头结点 最后使他指向null
        Node hh=new Node(-1);//新建一个头结点
        hh.next=head;
        h=hh;
        if(head==null){
            return null;
        }
        if (head.next!=null){
            p=hh.next;
            hn=hh.next;
        }else{
            return null;
        }
        while(p!=null){
            //尾节点需要将头结点指向尾节点，并将第一个节点head的next指定为null
            if (p.next==null){
                hh.next=p;
                p.next=h;
                hn.next=null;
                return hh.next;
            }else{
                q=p.next;
                p.next=h;
                h=p;
                p=q;
            }


        }
        return null;
    }
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null)return true;
        if(root1==null) return false;
        if(root1.val!=root2.val)return false;
        return HasSubtree(root1.left,root2.left)&&HasSubtree(root1.right,root2.right);
    }
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(8);
        TreeNode t2=new TreeNode(8);
        TreeNode t3=new TreeNode(7);
        TreeNode t4=new TreeNode(9);
        TreeNode t5=new TreeNode(2);
        TreeNode t7=new TreeNode(4);
        TreeNode t8=new TreeNode(7);
       t1.left=t2;
       t1.right=t3;
       t2.left=t4;
       t2.right=t5;
       t5.left=t7;
       t5.right=t8;

        TreeNode t9=new TreeNode(8);
        TreeNode t0=new TreeNode(2);
        TreeNode t=new TreeNode(9);
        t9.left=t;
        t9.right=t0;
        System.out.println(HasSubtree(t1,t9));
       /* Node head=new Node(0);
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);
        Node n7=new Node(7);
        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=null;
        ReverseList r=new ReverseList();
        Node h=r.ReverseList(head);
        while(h!=null){
            System.out.println(h.value);
            h=h.next;
        }*/
    }
}
