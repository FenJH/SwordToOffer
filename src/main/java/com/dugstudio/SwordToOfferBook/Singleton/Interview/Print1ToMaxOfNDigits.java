package com.dugstudio.SwordToOfferBook.Singleton.Interview;

/**
 * @Author JH
 * @CreateDate 18-6-8
 * @Descriptionv 从1 打印n位数 eg：1,2,3...,999...999
 */
public class Print1ToMaxOfNDigits {
    public void  Print1ToMaxOfNDigits(int n) {
        byte number[] = new byte[n];
        for (byte i = 0; i < 10; i++) {
            number[0]=i;
            Print1ToMaxOfNDigitsByRecrusive(number, n, 0);
        }
    }
    public void Print1ToMaxOfNDigitsByRecrusive(byte [] number ,int len, int index){
        if (index==len-1){
            printNumber(number);
            return ;
        }
        for (byte i=0;i<10;i++){
            number[index+1]=i;
            Print1ToMaxOfNDigitsByRecrusive(number,len,index+1);
        }
    }
    //从左第一位非0位至右打印
    public void printNumber(byte[] number){
          boolean flag=false;
        for (byte b:number
             ) {
            if (b!=0)flag=true;
            if (flag){
                System.out.print(b);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Print1ToMaxOfNDigits p=new Print1ToMaxOfNDigits();
        p.Print1ToMaxOfNDigits(3);
    }

}
