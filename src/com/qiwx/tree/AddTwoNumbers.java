package com.qiwx.tree;

import com.qiwx.model.ListNode;

import java.util.LinkedList;

//两数相加 II
public class AddTwoNumbers {
    public static void main(String[] args) {
      ListNode l1=new ListNode(7);
      l1.next=new ListNode(2);
      l1.next.next=new ListNode(4);
      l1.next.next.next=new ListNode(3);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        addTwoNumbers(l1,l2);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode=new ListNode(0);
        LinkedList<Integer> list1=new LinkedList();
        LinkedList<Integer> list2=new LinkedList();
        LinkedList<Integer> list3=new LinkedList();
        while (l1!=null){
            list1.addFirst(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            list2.addFirst(l2.val);
            l2=l2.next;
        }
        int size=list1.size()<list2.size()?list2.size():list1.size();
        int curray=0;
        for(int i=0;i<size;i++){
            int a=list1.isEmpty()?0:list1.pollFirst();
            int b=list2.isEmpty()?0:list2.pollFirst();
            int x=a+b+curray;
            if(x>=10){
                curray=1;
                x=x%10;
            }else {
                curray=0;
            }
            list3.addFirst(x);

        }
        if(curray==1){
            list3.addFirst(1);
        }
        ListNode current=listNode;//中间变量
        while (!list3.isEmpty()){
            current.next=new ListNode(list3.poll());
            current=current.next;
        }
        return listNode.next;

    }

}
