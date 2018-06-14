package com.dugstudio.SwordToOfferBook.Singleton.Interview;

/**
 * @Author JH
 * @CreateDate 18-6-9
 * @Description
 */

public class VerifySquenceOfBST {
    //方法一
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null||sequence.length==0)return false;
        if (fun(sequence,0,sequence.length-1)!=null)return true;
        return false;
    }
    public TreeNode fun(int []sequence,int st,int ed){
        if (ed==-1)return null;//没有右子树了
        if (st==ed)return new TreeNode(sequence[st]);
        TreeNode root=new TreeNode(sequence[ed]);
        for(int i=st;i<ed;i++){
            if (sequence[i]<sequence[ed]);
            else{//判断右子树的值是不是都大于根节点
                for (int j=i+1;j<ed;j++){
                    if (sequence[j]<sequence[ed]){
                        return null;
                    }
                }
                root.left=fun(sequence,st,i-1);
                root.right=fun(sequence,i,ed-1);
            }
        }
        return root;
    }
    //方法二
    public boolean VerifySquenceOfBST_1(int [] sequence ,int st ,int length) {
        if (sequence==null||length<=0)return false;
        int root=sequence[length-1];
        int i=st;
        //寻找左子树的范围（0，i-1）
        for (;i<length;i++){
            if (sequence[i]>=root){
                break;
            }
        }
        //验证右子树的数字是不是都大于根节点
        for (int j=i+1;j<length;j++){
            if (sequence[j]<root)return false;
        }
        //有右子树
        boolean left=true;
        if (i>st){
            left=VerifySquenceOfBST_1(sequence,st,i);
        }
        //有左子树
        boolean right=true;
        if (i<length-1){
            right=VerifySquenceOfBST_1(sequence,i,length-i-1);
        }
        return left&&right;
    }
    public static void main(String[] args) {
        VerifySquenceOfBST v=new VerifySquenceOfBST();
        int [] se={5,7,6,9,11,10,8};
        int [] ss={4,8,6,12,16,14,10};
        int s[]={5,4,3,2,1};
        int[] a={7,4,6,5};
       // System.out.println(v.VerifySquenceOfBST(se));
        //System.out.println(v.VerifySquenceOfBST(ss));
        //System.out.println(v.VerifySquenceOfBST(s));
        System.out.println(v.VerifySquenceOfBST_1(s,0,s.length));
        System.out.println(v.VerifySquenceOfBST_1(a,0,a.length));
    }
}
