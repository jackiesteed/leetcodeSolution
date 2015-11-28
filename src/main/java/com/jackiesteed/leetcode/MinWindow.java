package com.jackiesteed.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fangxue on 15/11/29.
 */
public class MinWindow {



    public String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (Character c : t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }
        int start = 0, end = 0;

        int bestLength = s.length() + 1;
        int bestStart = -1, bestEnd = -1;

        while(end < s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
            }
            end++;
            while(start < end){
                c = s.charAt(start);
                if(map.containsKey(c)){
                    if(map.get(c) >= 0)
                        break;
                    map.put(c, map.get(c) + 1);
                }
                start++;
            }

            boolean bingo = true;

            for(Map.Entry<Character, Integer> entry : map.entrySet()){
                if(entry.getValue() > 0){
                    bingo = false;
                    break;
                }
            }

            if(bingo){

                if(bestLength > end - start){
                    bestLength = end - start;
                    bestStart = start;
                    bestEnd = end;
                }

            }

        }

        if(bestLength < s.length() + 1){
            return s.substring(bestStart, bestEnd);
        }else{
            return "";
        }

    }


    public static void main(String[] args){

        System.out.println(new MinWindow().minWindow("a", "aa"));
    }
}
