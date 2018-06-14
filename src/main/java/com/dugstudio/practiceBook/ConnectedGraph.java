package com.dugstudio.practiceBook;

/**
 * @Author JH
 * @CreateDate 18-6-6
 * @Description  通过邻接矩阵求图的连通性
 */
public class ConnectedGraph {
    public boolean connected(int[][] A,int st,int ed){
        if (A.length==1)return true;
        else{
            for(int j=st;j<ed;j++)
            if (!connected(A,j,ed-1))return false;
            else {
                for(int i=0;i<A.length-1;i++){
                    if (A[A.length-1][i]==1)return true;
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ConnectedGraph c=new ConnectedGraph();
        int [][] aa={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        c.connected(aa,0,3);
    }
}
