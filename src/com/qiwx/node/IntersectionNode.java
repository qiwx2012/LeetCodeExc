package com.qiwx.node;

import com.qiwx.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description
 * @Author qiwx
 * @Date 2021-06-04 09:54
 * 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，
 * 请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null
 **/
public class IntersectionNode {
    public static void main(String[] args) {

    }

    //哈希方案
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> sets = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            sets.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (sets.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;

    }

    //双指针方案
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;

    }
}
