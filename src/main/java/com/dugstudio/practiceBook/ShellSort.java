package com.dugstudio.practiceBook;

/**
 * @Author JH
 * @CreateDate 18-6-7
 * @Description 希尔排序
 */
//使用int数组时要将泛型继承改为Integer这样才能使用compareTo
public class ShellSort <E extends Character> {
    public void  shellSort(E [] array,int d){
        if (d<1)return;//递归结束的条件
        int d1=d/2;//每次分组的步数
        for(int i=0;i<d1;i++)//循环终止条件是每次的步数，如果超过会造成死循环
        sort(array,d1,i);
        shellSort(array,d1);//对每次分组排序之后递归调用本身，但是步长变为一半
    }
    //划分之后每组用插入排序
    public void sort(E []array,int d,int st){
        int len=array.length;
        for (int i=st;i<len;i=i+d){
            for(int j=i-d;j>=0;j=j-d)
            if (array[j].compareTo(array[j+d])>0){
                swap(array,j,j+d);
            }
        }
    }
    private void swap(E array[],int i, int i1) {
        E temp=array[i];
        array[i]=array[i1];
        array[i1]=temp;
    }

    public static void main(String[] args) {
        Character []aa={'S','H','E','L','L','S','O','O','T','I','S','U','S','E','F','U','L'};
        int [] bb={9,8,7,6,5,4,3,2,1};
        ShellSort s=new ShellSort();
        s.shellSort(aa,aa.length);
       // s.shellSort(bb,bb.length);
        for (char i:aa
             ) {
            System.out.print(i+" ");
        }

    }
}
