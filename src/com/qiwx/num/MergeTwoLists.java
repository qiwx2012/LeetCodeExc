package com.qiwx.num;

import com.qiwx.model.ListNode;

//合并两个有序链表
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);
        ListNode l2=new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);
        System.out.println(mergeTwoLists(l1,l2));
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode current=result;
        while (l1!=null&&l2!=null){
                if(l1.val<l2.val){
                    current.next=l1;
                    current=current.next;
                    l1=l1.next;
                }else{
                    current.next=l2;
                    current=current.next;
                    l2=l2.next;
                }
        }
        if(l1==null){
            current.next=l2;
        }else{
            current.next=l1;
        }

        return result.next;
    }
}
