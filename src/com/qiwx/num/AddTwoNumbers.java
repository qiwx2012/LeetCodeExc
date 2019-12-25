package com.qiwx.num;

import com.qiwx.model.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(addTwoNumbers1(l1, l2));

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = l1.val + l2.val;
        //余数，如果a大于10余数为1 否则余数为0 大于10要往前进一位
        int carry = a / 10;
        //初始化listNode val为a10的取模
        ListNode result = new ListNode(a % 10);
        ListNode left = l1;
        ListNode right = l2;
        while (left.next != null || right.next != null) {
            int ll1;
            int ll2;
            if (left.next != null) {
                left = left.next;
                ll1 = left.val;
            } else {
                ll1 = 0;
            }
            if (right.next != null) {
                right = right.next;
                ll2 = right.val;
            } else {
                ll2 = 0;
            }
            int c = ll1 + ll2 + carry;
            carry = c / 10;
            ListNode listNode = new ListNode(c % 10);
            //添加到最后一个节点
            ListNode addNode = result;
            while (addNode.next != null) {
                addNode = addNode.next;
            }
            addNode.next = listNode;
        }
        if (carry > 0) {
            ListNode addNode = result;
            while (addNode.next != null) {
                addNode = addNode.next;
            }
            addNode.next = new ListNode(carry);
        }
        return result;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        //余数，如果a大于10余数为1 否则余数为0 大于10要往前进一位
        int carry = sum / 10;
        //初始化listNode val为a10的取模
        ListNode result = new ListNode(sum % 10);
        ListNode left = l1;
        ListNode right = l2;
        //添加到最后一个节点
        ListNode addNode = result;
        while (left.next != null || right.next != null) {
            sum = 0;
            if (left.next != null) {
                left = left.next;
                sum += left.val;
            }
            if (right.next != null) {
                right = right.next;
                sum += right.val;
            }
            sum = sum + carry;
            carry = sum / 10;
            ListNode listNode = new ListNode(sum % 10);
            //添加到最后一个节点
            addNode.next = listNode;
            addNode = addNode.next;
        }

        if (carry > 0) {
            addNode.next = new ListNode(carry);
        }
        return result;
    }
}
