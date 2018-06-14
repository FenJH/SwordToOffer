package com.dugstudio.practiceBook;

/**
 * @Author JH
 * @CreateDate 18-6-12
 * @Description 翻薄饼 有n张大小各不相同的薄饼，一张叠在另一张上面 将大的放在下边，
 * 先查找最大的数，如果这个数在最后，不用进行操作，如果这个数在第一位，只需要翻一次，即数组整体换位，
 * 否则要进行两次交换，第一次将这个数换到第一位，然后再转至数组，使得这个数变为最后一个
 */
public class Pancake {
    public void fun_1(int [] array){
        int j=array.length;
        while (j>0){
            int i=j-1 ,max=array[i],index=i;
            for (;i>=0;i--){
               if (max<array[i]){
                   max=array[i];
                   index=i;
               }
            }
            if(index!=j-1) {
                swap(array, index);
                swap(array, j - 1);
            }
            j--;
        }
    }

    private void swap(int[] array, int i1) {
        int temp;
        for (int m=0;m<(i1+1)/2;m++){
            temp=array[m];
            array[m]=array[i1-m];
            array[i1-m]=temp;
        }
    }

    public static void main(String[] args) {
        int a[]={2,4,7,4,6,1,9};
        Pancake p=new Pancake();
        p.fun_1(a);
        for (int i:a){
            System.out.println(i);
        }
    }
}
