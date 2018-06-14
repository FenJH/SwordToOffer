package com.dugstudio.practiceBook;

/**
 * @Author JH
 * @CreateDate 18-6-10
 * @Description 约瑟夫斯问题
 */
public class JosephusProblem {
    /**
     * 当n为奇数时f(n)=2*f((n-1)/2)+1
     * 当n为偶数时f(n)=2*f(n/2)-1
     * 递归结束的标志就是n=1
     * @param n
     * @return
     */
    public int fun_1(int n){
        if (n==1)return 1;
        if ((n&1)==1){
            return 2*fun_1((n-1)/2)+1;
        }else {
            return 2*fun_1(n/2)-1;
        }
    }

    /**
     * 约瑟夫斯问题的推广
     * @param n n个人
     * @param m 每m个杀一个人
     * @return
     */
    public int fun_2(int n,int m){
        int sum=0;
        for (int i=2;i<=n;i++){
            sum=(sum+m)%i;
        }
        return sum+1;
    }

    /**
     * 约瑟夫斯问题的简便解法
     * @param n
     * @return
     */
    public int fun_3(int n){
        //将n转化为二进制
       String  str=Integer.toBinaryString(n) ;
       //循环左移
        str=str.substring(1)+str.charAt(0);
       return Integer.parseInt(str,2);
    }
    public static void main(String[] args) {
        JosephusProblem j=new JosephusProblem();
        System.out.println(j.fun_1(1) );
        System.out.println(j.fun_2(40,2));
        System.out.println(j.fun_3(6));

    }
}
