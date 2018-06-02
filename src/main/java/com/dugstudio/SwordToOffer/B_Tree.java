package com.dugstudio.SwordToOffer;

/**
 * @Author JH
 * @CreateDate 18-5-31
 * @Description B-树实现
 */
class Node{
    int num;
    int []key;
    Node parent;
    Node []child;

    public Node(int m) {
        this.key = new int[m];
        this.child =new Node[m];
    }

    public Node(int num, int[] key, Node parent, Node[] child) {
        this.num = num;
        this.key = key;
        this.parent = parent;
        this.child = child;
    }
}
class Result{
    Node r;
    int i;
    int tag;
}
public class B_Tree {
    public Result B_TreeSearch(Node root,int k){
        Node p=root;
        Node q=null;
        Result r=new Result();
        int i=0;
        boolean find=false;
        while (p!=null&&!find){//没有找到k或者p不为空
            i=search(root,k);//返回k的位置
            if (k==p.key[i]&&find==false){
                find=true;
            }else{//q记录k应该插入的节点
                q=p;
                p=p.child[i];
            }
        }
        r.i=i;
        if (find){
           r.r=p;//查找成功则返回该节点
           r.tag=1;
        }else{//查找失败就返回k应该插入的节点的信息
            r.r=q;
            r.tag=0;
        }return r;
    }
    public  int search (Node root,int k){
        int i=0;//找到关键字k在root的关键字中的位置 使得key[i]<k<key[i+1]
        for(;i<root.num&&root.key[i+1]<=k;i++);
        return i;
    }
}
