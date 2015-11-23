package com.jackiesteed.leetcode;

/**
 * Created by fangxue on 15/11/23.
 */
public class MinimunInRotatedSortedArray {


    public static int findMin(int[] nums) {

        if(nums.length == 0)
            return  0;
        if(nums.length == 1)
            return nums[0];

        int start = 0, end = nums.length - 1;

        while(start < end){
            if(start + 1 == end)
                return Math.min(nums[start], nums[end]);

            if(nums[start] > nums[end]){
                int mid = (start + end) / 2;
                if(nums[mid] > nums[end]){
                    start = mid;
                }else{
                    end = mid;
                }
            }else{
                return nums[start];
            }

            System.out.println(start + " " + end);
        }

        return nums[start];

    }



    public static void main(String[] args){

        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));



    }
}
