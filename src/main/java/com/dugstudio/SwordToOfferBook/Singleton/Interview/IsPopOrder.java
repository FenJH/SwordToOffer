package com.dugstudio.SwordToOfferBook.Singleton.Interview;

import java.util.Stack;

/**
 * @Author JH
 * @CreateDate 18-6-9
 * @Description 判断给定出栈序列是否符合 进栈次序的出栈可能
 * 利用辅助栈
 */
public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> assistStack=new Stack<Integer>();
        int index=0;int i=0;
        if (pushA==null||popA==null)return false;
        for (;i<pushA.length;i++){
            int e=popA[i];
            //如果当前出栈元素在辅助栈顶，直接将栈顶元素出栈
            if (!assistStack.isEmpty()&&e==assistStack.peek()){
                assistStack.pop();
                //如果还有元素没有进栈 且辅助栈为空（初始状况）或者当前出栈元素不是栈顶元素
                // 就将进栈次序中位于当前元素前面的元素进辅助栈
            }else if(index<pushA.length&&(assistStack.isEmpty()||e!=assistStack.peek())){
                index=pushStack(pushA,e,index,assistStack);
                //栈顶元素不是当前出栈元素则不匹配
                if (e==assistStack.peek())
                assistStack.pop();
                else return false;
            }else{
                return false;
            }
        }
        //遍历出栈次序且辅助栈为空说明是该进栈次序的出栈次序
        if (i==pushA.length&&assistStack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
    public int  pushStack(int [] pushA,int e,int start,Stack<Integer> assistStack){
        for (int j=start;j<pushA.length;j++){
            assistStack.push(pushA[j]);
            if (e==pushA[j]){
                return j+1;
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        IsPopOrder i=new IsPopOrder();
        int push[] ={1,2,3,4,5};
        int [] pop={4,3,5,1,2};
        int [] qq={4,5,3,2,1};
        System.out.println(i.IsPopOrder(push,pop) );
        System.out.println(i.IsPopOrder(push,qq) );
    }
}
