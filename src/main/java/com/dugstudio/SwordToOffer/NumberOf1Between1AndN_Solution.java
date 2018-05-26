package com.dugstudio.SwordToOffer;

/**
 *
 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 编程之美上给出的规律：

 1. 如果第i位（自右至左，从1开始标号）上的数字为0，则第i位可能出现1的次数由更高位决定（若没有高位，视高位为0），等于更高位数字X当前位数的权重10i-1。

 2. 如果第i位上的数字为1，则第i位上可能出现1的次数不仅受更高位影响，还受低位影响（若没有低位，视低位为0），等于更高位数字X当前位数的权重10i-1+（低位数字+1）。

 3. 如果第i位上的数字大于1，则第i位上可能出现1的次数仅由更高位决定（若没有高位，视高位为0），等于（更高位数字+1）X当前位数的权重10i-1
 */
public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n,int m) {
        int sum=0;
        int i=1;int  x,y=n;
        while(y>0){
             x=n%(int)Math.pow(10,i-1);
             int current=y%10;
             y=n/(int)Math.pow(10,i);
             sum+=y*(int)Math.pow(10,i-1);
            if (current>m){
                sum+=(int)Math.pow(10,i-1);
            }
            else if (current==m){
                sum+=x+1;
            }
            i++;
        }
    return sum;
    }

    public static void main(String[] args) {
        NumberOf1Between1AndN_Solution m=new NumberOf1Between1AndN_Solution();
         System.out.println(m.NumberOf1Between1AndN_Solution(2593,5));
    }
}
