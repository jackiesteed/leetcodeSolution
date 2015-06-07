package com.jackiesteed.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jackie on 5/16/15.
 */
public class ScrambleString {

    public boolean isScramble(String s1, String s2) {

        Map<Character, Integer> countMap = new HashMap<Character, Integer>();

        for(int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            if(countMap.containsKey(c)){
                countMap.put(c, countMap.get(c) + 1);
            }else{
                countMap.put(c, 1);
            }
        }

        for(int i = 0; i < s2.length(); i++){
            char c = s2.charAt(i);
            if(!countMap.containsKey(c))
                return false;
            countMap.put(c, countMap.get(c) - 1);
        }

        for(Map.Entry<Character, Integer> entry : countMap.entrySet()){
            if(entry.getValue() != 0)
                return false;
        }
        return true;
    }
}
