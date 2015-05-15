package com.jackiesteed.leetcode;

/**
 * Created by jackie on 5/10/15.
 */
public class ReverseNodesInKGroup {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode circleStart = null, circleEnd = null;

        ListNode node = head, next;

        int count = 0;
        while(true){
            next = node.next;
            if(circleEnd == null)
                circleEnd = node;
            if(circleStart == null)
                circleStart = node;
            else{
                node.next = circleStart;
                circleStart = node;
            }

            count += 1;

            if(count == k){
                circleEnd.next = null;
            }


        }
    }
}
