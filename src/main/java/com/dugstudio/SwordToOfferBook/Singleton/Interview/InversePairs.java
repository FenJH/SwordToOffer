package com.dugstudio.SwordToOfferBook.Singleton.Interview;

import java.util.Arrays;

/**
 * @Author JH
 * @CreateDate 18-6-10
 * @Description  数组中的逆序对
 */
public class InversePairs {
    /**
     * 数组中的逆序对 利用归并排序
     * 浪费了copy的空间 以空间换时间
     */
    private static int [] copy;
    public int InversePairs(int [] array) {
            if(array==null||array.length<=0)return 0;
            copy=new int[array.length];
            for (int i=0;i<array.length;i++){
                copy[i]=array[i];
            }
            return InversePairs(array,copy,0,array.length-1);
    }

    private int InversePairs(int[] array, int[] copy, int start, int high) {
        if (start==high){
            //划分到只剩一个元素
            copy[start]=array[start];
            return 0;
        }
        int mid=(high+start)>>1;
        int left=InversePairs(array,copy,start,mid);
        int right=InversePairs(array,copy,mid+1,high);
        int i=mid,count=0;
        int k=high,j=high;
        //合并左右分路 从左右的最后一个元素开始比较 将大者放在copy的start-end的最后一个位置
        while(i>=start&&j>mid){
            if (array[i]>array[j]){
                //左边元素大于右边元素,则j-mid个元素都可以和左边的元素组成逆序对
                count+=j-mid;
                copy[k--]=array[i--];
            }else{
                copy[k--]=array[j--];
            }
        }
        while(i>=start){
            copy[k--]=array[i--];
        }
        while (j>mid){
            copy[k--]=array[j--];
        }
        //将copy数组排序后的对应位置复制给array
        for (int m=start;m<=high;m++){
            array[m]=copy[m];
        }
        return count+left+right;
    }

    /**
     * 归并排序
     * @param array
     * @param start
     * @param end
     */
    public void inverse(int [] array,int start,int end){
        if (start==end)return ;
        int mid=(end+start)/2;
        inverse(array,start,mid);
        inverse(array,mid+1,end);
        merge(array,start,end);
    }
    public void  merge(int [] array,int start,int end){
        for(int i=start;i<=end;i++){
            int min=array[i];int index=i;int j=i+1;
            for (;j<=end;j++){
                if (min>array[j]){
                    min=array[j];
                    index=j;
                }
            }
            if (min!=Integer.MAX_VALUE){
                array[index]=array[i];
                array[i]=min;
            }
        }
    }

    public static void main(String[] args) {
        int [] a={7,5,6,4};
        int [] b={1,2,3,4,5,6,7,0};
        InversePairs i=new InversePairs();
        //i.inverse(b,0,b.length-1);
       // i.inverse(a,0,a.length-1);
        System.out.println(i.InversePairs(a));
        for (int m:copy){
            System.out.print(m);
        }
    }
}
