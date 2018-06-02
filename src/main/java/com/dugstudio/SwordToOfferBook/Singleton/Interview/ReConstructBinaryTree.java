package com.dugstudio.SwordToOfferBook.Singleton.Interview;

/**
 * @Author JH
 * @CreateDate 18-5-31
 * @Description
 */

/**
 * Create by ~JH~ on 2018/4/30
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列
 * {4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }
    public TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
        if (startPre>endPre||startIn>startPre){
            return null;
        }
        TreeNode root=new TreeNode(pre[startPre]);
        for (int i=startIn;i<=endIn;i++){
            if (pre[startPre]==in[i]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int pre[]={1,2,4,3,5,6};
        int in[]={4,2,1,5,3,6};
        ReConstructBinaryTree r=new ReConstructBinaryTree();
        TreeNode root=r.reConstructBinaryTree(pre,in);
        r.print(root);
    }

    /**
     * 先序遍历
     * @param root
     */
    private void printPre(TreeNode root) {
        if (root!=null){
            System.out.print(" "+root.val);
        }
        if (root.left!=null){
            printPre(root.left);
        }
        if (root.right!=null){
            printPre(root.right);
        }
    }

    /**
     * 非递归的后序遍历
     * @param root
     */
    public void print(TreeNode root){
        if (root==null){
            return ;
        }
        if(root.left!=null){
            print(root.left);
        }
        if (root.right!=null){
            print(root.right);
        }
        System.out.print(" "+root.val);

    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}