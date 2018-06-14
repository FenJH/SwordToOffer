package com.dugstudio.SwordToOfferBook.Singleton.Interview;

import java.util.Stack;

/**
 * @Author JH
 * @CreateDate 18-6-9
 * @Description
 */
public class TreeConvertToList {
    public TreeNode Convert(TreeNode pRootOfTree) {
        fun(pRootOfTree);
        return realHead;
    }
    TreeNode head=null,realHead=null;
    public  void fun(TreeNode pRootOfTree){
        if (pRootOfTree==null)return;
        fun(pRootOfTree.left);
        if (head==null){
            realHead=pRootOfTree;
            head=pRootOfTree;
        }else{
            head.right=pRootOfTree;
            pRootOfTree.left=head;
            head=pRootOfTree;
        }
        fun(pRootOfTree.right);
    }
}
