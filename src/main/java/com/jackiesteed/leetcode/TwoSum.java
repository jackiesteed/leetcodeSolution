package com.jackiesteed.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jackie on 4/23/15.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(map.containsKey(target - nums[i])){
                int[] res = new int[2];
                res[0] = map.get(target - nums[i]) + 1;
                res[1] = i + 1;
                return res;
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
