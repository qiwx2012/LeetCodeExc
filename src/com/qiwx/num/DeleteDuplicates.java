package com.qiwx.num;
//删除排序链表中重复的元素
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(1);
        l1.next.next=new ListNode(2);
        l1.next.next.next=new ListNode(3);
        l1.next.next.next.next=new ListNode(3);
        deleteDuplicates1(l1);
    }
    private static ListNode deleteDuplicates1(ListNode head){
        if(head==null)
            return null;
         ListNode currnt=head;
        while (currnt!=null&&currnt.next!=null){
            if(currnt.val==currnt.next.val){
                currnt.next=currnt.next.next;
            }else{
                currnt=currnt.next;
            }
        }
        return head;
    }

    private static ListNode deleteDuplicates(ListNode head){
        if(head==null)
            return null;
        //核心思想是，addNode始终指向next节点，初始时node代表result
        //链表指向下一个节点时，node又被重新赋值，指向最后一个节点。
        ListNode result=new ListNode(head.val);
        ListNode addNode=result;
        while (head.next!=null){
            if(addNode.val==head.next.val){
                head=head.next;
            }else{
                ListNode listNode=new ListNode(head.next.val);
                addNode.next=listNode;
                addNode=addNode.next;
                head=head.next;
            }
        }
        return result;

    }
}
