package com.dugstudio.SwordToOffer;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/**
 *
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {

        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            boolean flag=false;
            while(pHead1.next!=null){
                 flag=false;
                while (pHead2.next!=null){
                    if (pHead1.val==pHead2.val){
                        flag=true;
                        break;
                    }
                    else{
                        pHead2=pHead1.next;

                    }
                }
                if (flag)break;
                pHead1=pHead1.next;
            }
            if (flag)return pHead1;
            else return null;
        }

}
