package com.jackiesteed.leetcode;

/**
 * Created by jackie on 5/3/15.
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        if(nums.length == 0)
            return -1;
        if(nums.length == 1){
            if(nums[0] == target)
                return 0;
            return -1;
        }

        int left = nums[0];
        int right = nums[nums.length - 1];
        int start = 0, end = nums.length - 1;
        int mid = (start + end) / 2;

        while(true){

        }

    }
}
