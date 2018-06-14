package com.dugstudio.SwordToOfferBook.Singleton.Interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JH
 * @CreateDate 18-6-9
 * @Description
 */
public class FindPathFromTree {
    ArrayList<ArrayList<Integer>> all=new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
            if (root==null)return null;
        FindPath(root,target,0,new ArrayList<Integer>());
        return all;
    }
    public void FindPath(TreeNode root,int target,int currentSum,ArrayList<Integer> list) {

        if (currentSum==target&&root.left==null&&root.right==null){
             all.add(new ArrayList<Integer>(list));
             list.remove(root.val);
             return ;
        }
        currentSum+=root.val;
        if (currentSum>target) return ;
        list.add(root.val);
        if (root.left!=null){
            FindPath(root.left,currentSum,target,list);
        }
        if (root.right!=null){
            FindPath(root.right,target,currentSum,list);
        }
    }
}
