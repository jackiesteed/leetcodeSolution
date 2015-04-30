package com.jackiesteed.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jackie on 4/19/15.
 */
public class Integer2Roman {

    Map<Integer, String> map = new HashMap<Integer, String>();
    List<Integer> list = new ArrayList<Integer>();


    public String intToRoman(int num){
        if(num == 0)
            return "";

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        list.add(1000);
        list.add(900);
        list.add(500);
        list.add(400);
        list.add(100);
        list.add(90);
        list.add(50);
        list.add(40);
        list.add(10);
        list.add(9);
        list.add(5);
        list.add(4);
        list.add(1);

        for(Integer t : list){
            if(num >= t){
                return repeat(map.get(t), num / t) + intToRoman(num % t);
            }
        }
        return "";
    }

    public String repeat(String s, int times){
        StringBuilder builder = new StringBuilder();
        while(times > 0){
            builder.append(s);
            times--;
        }
        return builder.toString();

    }

}
