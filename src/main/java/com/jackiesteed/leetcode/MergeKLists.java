package com.jackiesteed.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by jackie on 5/1/15.
 */
public class MergeKLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }



    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0)
            return null;

        ListNode head = null;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for(ListNode node : lists){
            if(node != null)
                priorityQueue.add(node);
        }

        ListNode cur = null;


        while(priorityQueue.size() > 0){

            ListNode listNode = priorityQueue.poll();

            if(head == null){
                head = listNode;
            }
            else{
                cur.next = listNode;
            }
            cur = listNode;
            if(listNode.next != null)
                priorityQueue.add(listNode.next);
        }

        return head;

    }
}
