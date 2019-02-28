package com.qiwx.tree;

import com.qiwx.model.ListNode;

// 删除链表中的节点
public class DeleteNode {
    public static void main(String[] args) {

    }
    public void deleteNode(ListNode node) {
       node.val=node.next.val;
       node.next=node.next.next;

    }
}
