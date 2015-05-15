package com.jackiesteed.leetcode;

/**
 * Created by jackie on 5/1/15.
 */
public class RegularExpressionMatching {

    private String normalizePattern(String p){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '*' && i > 0 && p.charAt(i - 1) == '*')
                continue;
            stringBuilder.append(p.charAt(i));
        }
        return stringBuilder.toString();
    }

    public boolean isMatch(String s, String p) {

        p = normalizePattern(p);

        if(s.length() == 0){
            if(p.length() == 0)
                return true;
            int len = p.length();
            for(int i = 0; i < len; i++){
                if(p.charAt(i) != '*'){
                    if(i + 1 >= len || p.charAt(i + 1) != '*')
                        return false;
                }
            }
            return true;
        }
        if(p.length() == 0)
            return false;







        return false;

    }
}
