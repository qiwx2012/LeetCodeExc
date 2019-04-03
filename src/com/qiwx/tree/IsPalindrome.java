package com.qiwx.tree;

import com.qiwx.model.ListNode;

import java.util.LinkedList;

//234. 回文链表
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode node=new ListNode(-129);
        node.next=new ListNode(-129);
        System.out.println(isPalindrome(node));
    }
    public static boolean isPalindrome(ListNode head) {
        LinkedList<Integer> list=new LinkedList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        while (list.size()>0){
            if(!list.peekFirst().equals(list.peekLast())){
                return false;
            }
            if(list.size()>0){
                list.pollFirst();
            }
            if(list.size()>0){
                list.pollLast();
            }
        }
        return true;

    }
    //利用快慢指针
    public static boolean isPalindrome1(ListNode head) {
        if(head==null||head.next==null)
            return true;
       ListNode slow=head;
       ListNode fast=head;
       while (fast.next!=null&&fast.next.next!=null){
           fast = fast.next.next;
           slow = slow.next;
       }
       //经过运行slow位中间位置
        slow = reverse(slow.next);
        while(slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
    private static ListNode reverse(ListNode head){
        // 递归到最后一个节点，返回新的新的头结点
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
