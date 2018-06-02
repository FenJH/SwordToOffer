package com.dugstudio.SwordToOfferBook.Singleton.Interview;

/**
 * @Author JH
 * @CreateDate 18-5-30
 * @Description  在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 */
public class TwoDimensionArrayLookup {
    public boolean Find(int target, int [][] array) {
        if (array.length==0||array==null)return false;
            for (int j=0 ,i = array[0].length - 1; j<array.length&&i >= 0; ) {
                if (target == array[j][i]) {
                    return true;
                }
                else if (target > array[j][i]) {
                    j++;
                }
                else {
                    i--;
                }
            }

        return false;
    }
    public static void main(String[] args) {
        int [][] num={
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,12},
                {6,8,11,15}
        };
        TwoDimensionArrayLookup t=new TwoDimensionArrayLookup();
        System.out.println(t.Find(16,num) );
    }
}
