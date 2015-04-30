package com.jackiesteed.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jackie on 4/23/15.
 */
public class SingleNumber {

    public int singleNumber(int[] nums){

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(Integer i : nums){
            if(map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1)
                return entry.getKey();
        }

        return 0;
    }
}
