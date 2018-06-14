package com.dugstudio.practiceBook;

import java.util.ArrayList;

/**
 * @Author JH
 * @CreateDate 18-6-7
 * @Description
 */
class Edge{
    private int st;//起点
    private int ed;//终点
    private int weight;//权重

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public int getEd() {
        return ed;
    }

    public void setEd(int ed) {
        this.ed = ed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
public class Graphy {
    private ArrayList<Integer> vertexList;
    private int [][] adjmatrix;
    public Graphy(int n) {
        this.vertexList=new ArrayList<Integer>(n);
        this.adjmatrix=new int[n][n];
        for (int j=0;j<n;j++)
        for(int i=0;i<n;i++){
            if (i==j)
            this.adjmatrix[j][i]=0;
            else
                this.adjmatrix[j][i]=Integer.MAX_VALUE;
        }
    }

    public Graphy(ArrayList<Integer> vertexList, int[][] adjmatrix) {
        this.vertexList = vertexList;
        this.adjmatrix = adjmatrix;
    }

    public Graphy(String vertexStr,Edge[] edges) {
        this.vertexList=new ArrayList<Integer>(vertexStr.length());
        for (int i=0;i<vertexStr.length();i++){
            insertVertex(Integer.parseInt(vertexStr.charAt(i)+""));
        }
        for(int i=0;i<edges.length;i++){
         insertEdge(edges[i].getSt(),edges[i].getEd(),edges[i].getWeight());
          }
    }
    public int vertexCount(){
        return this.vertexList.size();
    }
    public boolean insertVertex(int vertex){
        return this.vertexList.add(vertex);
    }
    public boolean insertEdge(int st,int ed,int weight){
        if (st>=0&&st<vertexCount()&&ed>=0&&ed<vertexCount()&&adjmatrix[st][ed]!=Integer.MAX_VALUE) {
            adjmatrix[st][ed] = weight;
            return true;
        }return false;
    }
    public boolean removeVertex(int vertex){
        if (vertex>=0&&vertex<vertexCount()){
            this.vertexList.remove(vertex);
            for (int i=vertex;i<vertexCount();i++){
                for(int j=0;j<vertexCount();j++){
                    adjmatrix[i][j]=adjmatrix[i+1][j];
                }
            }
            for (int i=vertex;i<vertexCount();i++){
                for(int j=0;j<vertexCount();j++){
                    adjmatrix[j][i]=adjmatrix[j][i+1];
                }
            }
            return true;
        }
        return false;

    }
    public boolean removeEdge(Edge edge){
        if (edge.getEd()>=0&&edge.getEd()<vertexCount()&&edge.getSt()>=0&&edge.getSt()<vertexCount()){
            adjmatrix[edge.getSt()][edge.getEd()]=Integer.MAX_VALUE;
            return true;
        }return false;
    }
 }
