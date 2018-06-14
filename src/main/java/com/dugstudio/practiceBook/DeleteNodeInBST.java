package com.dugstudio.practiceBook;

import java.util.Stack;

/**
 * @Author JH
 * @CreateDate 18-6-11
 * @Description 在二叉查找树中删除一个节点
 * 1.如果该节点是叶子节点 删除该节点
 * 2.如果该节点有左子树 将左子树的根节点代替该节点
 * 3.如果该节点只有右子树 将右子树根节点代替该节点
 * 4.既有左节点又有右节点，用右节点代替该节点 将左节点放在右节点的左子树的最左边
 */
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode( int val) {
        this.left = null;
        this.right = null;
        this.val = val;
    }
}
public class DeleteNodeInBST {
    public boolean delete(TreeNode root,int key){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode p=root,q;
        while(p!=null){
            System.out.println(p.val);
            stack.push(p);
            if (p.val==key){
                //删除节点的左右子树都为空 直接将父节点的该左子树或者右子树置空
                if (p.left==null&&p.right==null){
                    System.out.println(" p.left==null&&p.right==null"+p.val);
                    if(!stack.isEmpty()){
                        stack.pop();
                      q=stack.peek();
                      if (q.left==p){
                          q.left=null;
                          return true;
                      }else{
                          q.right=null;
                          return true;
                      }
                    }else{
                        return false;
                    }
                    //左子树为空 将右子树直接放到父节点的删除节点位置上
                }else if (p.left==null&&p.right!=null){
                    System.out.println(" p.left==null&&p.right!=null"+p.val);
                    if (!stack.isEmpty()){
                        stack.pop();
                        q=stack.peek();
                        if (q.left==p){
                            q.left=p.right;
                        }else {
                            q.right=p.right;
                        }
                    }else {
                        return false;
                    }
                    //右子树为空 左子树放到该节点位置上
                }else if(p.left!=null&&p.right==null){
                    System.out.println(" p.left!=null&&p.right==null"+p.val);
                    if (!stack.isEmpty()){
                        stack.pop();
                        q=stack.peek();
                        if (q.left==p){
                            q.left=p.left;
                        }else {
                            q.right=p.left;
                        }
                        return true;
                    }else {
                        return false;
                    }
                }else {
                    //左右子树都不为空 将左子树节点放到右子树的最左边
                    System.out.println(" p.left!=null&&p.right!=null"+p.val);
                    TreeNode n=p.right;
                    while (n.left!=null){
                        n=n.left;
                    }
                    if (!stack.isEmpty()){
                        stack.pop();
                        q=stack.peek();
                        if (q.left==p){
                            q.left=p.right;
                            n.left=p.left;
                        }else {
                            q.right=p.right;
                            n.left=p.left;
                        }
                        return true;
                    }else {
                        return false;
                    }

                }
            }else {
                if (p.val>key){
                    p=p.left;
                }else {
                    p=p.right;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(20);
        TreeNode t2=new TreeNode(10);
        TreeNode t3=new TreeNode(5);
        TreeNode t4=new TreeNode(3);
        TreeNode t5=new TreeNode(8);
        TreeNode t6=new TreeNode(7);
        TreeNode t7=new TreeNode(9);
        TreeNode t8=new TreeNode(15);
        TreeNode t9=new TreeNode(17);
        TreeNode t10=new TreeNode(40);
        TreeNode t11=new TreeNode(13);
        t1.left=t2;
        t1.right=t10;
        t2.left=t3;
        t2.right=t8;
        t8.left=t11;
        t8.right=t9;
        t3.left=t4;
        t3.right=t5;
        t5.left=t6;
        t5.right=t7;
        DeleteNodeInBST d=new DeleteNodeInBST();
        System.out.println(d.delete(t1,5) );
        System.out.println(d.delete(t1,9) );
        System.out.println(d.delete(t1,3) );

    }
}
