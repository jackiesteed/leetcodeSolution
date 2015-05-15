package com.jackiesteed.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jackie on 5/1/15.
 */
public class CopyRandomList {

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    ;

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;

        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode resHead = new RandomListNode(head.label);
        map.put(head, resHead);
        RandomListNode cur = head;
        RandomListNode resCur = resHead;
        while(cur.next != null){
            cur = cur.next;
            RandomListNode next = new RandomListNode(cur.label);
            map.put(cur, next);
            resCur.next = next;
            resCur = next;
        }

        cur = head;

        while(true){
            if(cur == null)
                break;
            resCur = map.get(cur);
            if(cur.random == null){

                resCur.random = null;
            }else{
                resCur.random = map.get(cur.random);
            }
            cur = cur.next;
        }

        return resHead;
    }
}
