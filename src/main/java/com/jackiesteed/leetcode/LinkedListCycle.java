package com.jackiesteed.leetcode;

/**
 * Created by jackie on 4/19/15.
 */
public class LinkedListCycle {

    class ListNode {
             int val;
             ListNode next;
             ListNode(int x) {
                     val = x;
                     next = null;
                 }
         }

    public boolean hasCycle(ListNode head) {

        if(head == null)
            return false;

        if(head.val == Integer.MAX_VALUE)
            return true;
        head.val = Integer.MAX_VALUE;
        return hasCycle(head.next);


    }
}
