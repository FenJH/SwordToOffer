package com.dugstudio.SwordToOffer;

import java.util.LinkedList;

/**
 * 树的深度递归和非递归算法
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
public class TreeDepth {
    /**
     * 递归
     * @param root
     * @return
     */
    public int TreeDepth1(TreeNode root){
        if(root==null)return 0;
        int left=TreeDepth1(root.left);
        int right=TreeDepth1(root.right);
        return left>right?left+1:right+1;
    }

    /**
     * 层次遍历非递归
     * @param root
     * @return
     */
    public int TreeDepth2(TreeNode root){
        if(root==null)return 0;
        int high=0,nextCount=1,count=0;
        LinkedList<TreeNode>queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.size()!=0){
            count++;
            TreeNode node=queue.poll();
            if (node.left!=null)queue.add(node.left);
            if (node.right!=null)queue.add(node.right);
            if(count == nextCount){
                nextCount = queue.size();
                count = 0;
                high++;
            }
        }
        return high;
    }
}
}
