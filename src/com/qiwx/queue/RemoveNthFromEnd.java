package com.qiwx.queue;

import com.qiwx.model.ListNode;

import java.util.LinkedList;

//删除链表到倒数第N个节点
public class RemoveNthFromEnd {
    public static void main(String[] args) {
     //ListNode lt=new ListNode(1);
     //lt.next=new ListNode(2);
//     lt.next.next=new ListNode(3);
//     lt.next.next.next=new ListNode(4);
//     lt.next.next.next.next=new ListNode(5);
     //removeNthFromEnd(lt,1);
        ListNode lt=new ListNode(1);
        lt.next=new ListNode(2);
        lt.next.next=new ListNode(3);
        ListNode lt2=lt;
        lt2=lt2.next;
        lt2=lt2.next;
        System.out.println(lt2.val);
        System.out.println(lt.val);



    }
    public static ListNode removeNthFromEnd(ListNode head,int n){
        ListNode result=new ListNode(0);
        LinkedList<Integer> data=new LinkedList<>();
        while (head!=null){
            data.add(head.val);
            head=head.next;
        }
        data.remove(data.size()-n);
        ListNode temp=result;
        for(Integer a:data){
            temp.next=new ListNode(a);
            temp=temp.next;
        }
        return result.next;

    }
    public static ListNode removeNthFromEnd1(ListNode head,int n){
        ListNode leader=head;
        ListNode flolwer=head;
        //leader先走n步
        for(int i=0;i<n+1;i++){
            if(leader==null){
                return head.next;
            }else {
                leader=leader.next;
            }
        }
        //两个指针同时前进，直到leader到末尾
        while (leader!=null){
            leader=leader.next;
            flolwer=flolwer.next;
        }
        //删除追随者处到节点
        flolwer.next=flolwer.next.next;
     return head;


    }
}
