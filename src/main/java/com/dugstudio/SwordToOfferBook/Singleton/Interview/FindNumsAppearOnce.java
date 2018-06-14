package com.dugstudio.SwordToOfferBook.Singleton.Interview;

/**
 * @Author JH
 * @CreateDate 18-6-14
 * @Description 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null||array.length<=0)return ;
        num1[0]=array[0];
        int [] start=new int[array.length];
        int [] end=new int[array.length];
        //相同的数字异或为0 两个不相同的数字异或最后的结果就说明他们对应位上为1
        for(int i=1;i<array.length;i++){
            num1[0]^=array[i];
        }
        int k=0,j=0;
        //通过num1[0]的1的位置上array数组的数字对应位是0还是1 将数组分成两个数组
        for(int i=0;i<array.length;i++){
            if((array[i]&num1[0])!=0){
                start[k++]=array[i];
            }else{
                end[j++]=array[i];
            }
        }
        //在两个数组中分别进行逐位异或找到那个只出现一次的数字
        num1[0]=start[0];
        num2[0]=end[0];
        for(int i=1;i<k;i++){
            num1[0]^=start[i];
        }
        for(int i=1;i<j;i++){
            num2[0]^=end[i];
        }

    }

    public static void main(String[] args) {
        FindNumsAppearOnce f=new FindNumsAppearOnce();
        int []array={2,4,3,6,3,2,5,5};
        int [] a1=new int[1],a2=new int [1];
        f.FindNumsAppearOnce(array,a1,a2);
        System.out.println(a1[0]+" "+a2[0]);

    }
}
