package com.jackiesteed.leetcode;

/**
 * Created by jackie on 4/19/15.
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums){
        int res = nums[0];
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            temp += nums[i];
            if(res < temp)
                res = temp;
            if(temp < 0)
                temp = 0;
        }

        return res;
    }

}
