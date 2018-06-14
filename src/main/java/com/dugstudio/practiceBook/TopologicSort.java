package com.dugstudio.practiceBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author JH
 * @CreateDate 18-6-7
 * @Description 拓扑排序 对于图中的每一条边，边的起始点总是排在终点之前
 */
public class TopologicSort {
    /**
     * 拓扑排序的DFS实现
     * @param vertex 点集
     * @param edges 有向边的邻接矩阵
     */
    private static List<Integer> seril=new ArrayList<Integer>();
    public void topoSortByDFS(int [] vertex,int[][] edges){

        boolean [] isVisited =new boolean[vertex.length];
        Stack<Integer> stack =new Stack<Integer>();
        for (int i=0;i<vertex.length;i++){
            boolean flag=false;
            for (int j=0;j<vertex.length;j++){
                if (edges[j][i]!=0){
                    flag=true;
                    break;
                }
            }//寻找没有入边的点
            if (flag==false){
                stack.push(vertex[i]);
                isVisited[vertex[i]]=true;
                topoSort(stack,vertex,isVisited,edges);
            }
        }
    }

    /**
     * DFS将有出边的点入栈，没有入边则出栈，回溯到上一个点，寻找下一个点
     * @param stack
     * @param vertex
     * @param isVisited
     * @param edges
     */
    private void topoSort(Stack<Integer> stack, int[] vertex, boolean[] isVisited, int[][] edges) {
            if (stack.isEmpty())return;
            while (!stack.isEmpty()){
                int i=0;
                for (;i<vertex.length;i++){
                    if (!isVisited[i]&&edges[stack.peek()][i]!=0){
                        stack.push(vertex[i]);
                        isVisited[i]=true;
                        topoSort(stack,vertex,isVisited,edges);
                        break;
                    }
                }
                if (i==vertex.length){
                    seril.add(stack.pop());
                }
            }

    }

    /**
     * 基于减一思想的拓扑排序，删除没有入边的源点
     * @param vertex 点集
     * @param edges 边集
     */
    public void topoSortBySub(int [] vertex,int[][] edges){
        boolean [] isVisited =new boolean[vertex.length];
        for (int i=0;i<vertex.length;i++){
            boolean flag=false;
            for (int j=0;j<vertex.length&&isVisited[vertex[i]]==false;j++){
                if (edges[j][i]!=0){
                    flag=true;
                    break;
                }
            }
            if (flag==false&&isVisited[vertex[i]]==false){
                seril.add(vertex[i]);
                isVisited[vertex[i]]=true;
                for (int k=0;k<vertex.length;k++){
                    edges[i][k]=0;
                    edges[k][i]=0;
                }

                i=-1;
            }
        }
    }
    public static void main(String[] args) {
        int [] vertex={0,1,2,3,4,5};
        int [][] matrix={
                {0,0,1,0,0,0},
                {0,0,1,0,0,0},
                {0,0,0,1,1,1},
                {0,0,0,0,1,0},
                {0,0,1,0,0,0},
                {0,0,0,0,0,0}
        };
        int [] vertex1={0,1,2,3,4,5,6};
        int [][] matrix1={
                {0,1,1,0,0,0,0},
                {0,0,0,0,1,0,1},
                {0,0,0,0,0,1,0},
                {1,1,1,0,0,1,1},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,1,1,1,0}
        };
        TopologicSort t=new TopologicSort();
        t.topoSortByDFS(vertex,matrix);
       // t.topoSortBySub(vertex,matrix);
        // t.topoSortByDFS(vertex1,matrix1);
        //t.topoSortBySub(vertex1,matrix1);
        System.out.println("出栈次序：");
        System.out.println(seril);
        System.out.println("拓扑排序次序：");
        for(int i=seril.size()-1;i>=0;i--){
            System.out.print(seril.get(i)+"  ");
        }
    }

}
