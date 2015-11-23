package com.jackiesteed.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by fangxue on 15/8/25.
 */
public class MaxSlidingWindow {

    public static class Node{
        public int pos;
        public int val;

        public Node(int  p, int v){
            this.pos = p;
            this.val = v;
        }
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {

        if(nums.length == 0)
            return new int[]{};

        int[] res = new int[nums.length - k + 1];
        int resIdx = 0;

        Deque<Node> deque = new LinkedList<Node>();

        int start = 0;
        int end = 0;

        //init
        while(true){
            while(!deque.isEmpty()){
                if(deque.getLast().val >= nums[end]){
                    deque.add(new Node(end, nums[end]));
                    break;
                }
                else{
                    deque.pollLast();
                }
            }
            if(deque.isEmpty())
                deque.add(new Node(end, nums[end]));

            end++;

            if(end == start + k){
                res[resIdx++] = deque.getFirst().val;
                start++;
                if(deque.getFirst().pos < start)
                    deque.pollFirst();
            }

            if(end >= nums.length)
                break;
        }

        return  res;
    }

    public static void main(String[] args){
        int[] res = maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);

        for(int i : res){
            System.out.println(i);
        }
    }
}
