package com.dugstudio.practiceBook;

/**
 * @Author JH
 * @CreateDate 18-6-10
 * @Description 俄式乘法
 */
public class EMultiply {
    public int mul(int i1,int j1){
        if (i1==0||j1==0)return 0;
        int sum=0,i=0,j=0;
        if (i1<0||j1<0){
            i=Math.abs(i1);
            j=Math.abs(j1);
        }
        while (i!=1){
            if ((i&1)==1){
                sum+=j;
            }
            i=i>>1;
            j=j<<1;
        }
     sum=sum+j;
        if (i1<0)sum=-sum;
        else if (j1<0)sum=-sum;
        return sum;
    }

    public static void main(String[] args) {
        EMultiply e=new EMultiply();
        System.out.println( e.mul(-1,65));
    }
}
