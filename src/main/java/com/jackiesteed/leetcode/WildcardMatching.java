package com.jackiesteed.leetcode;

/**
 * Created by jackie on 4/26/15.
 */
public class WildcardMatching {

    private String s,p;

    int[] realCharCountInPattern;

    private int[][] dp = null;

    private String normalizePattern(String p){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '*' && i > 0 && p.charAt(i - 1) == '*')
                continue;
            stringBuilder.append(p.charAt(i));
        }
        return stringBuilder.toString();
    }

    public boolean isMatch(String s, String p){

        if(s.length() == 0){
            if(p.length() == 0)
                return true;
            for(int i = 0; i < p.length(); i++)
                if(p.charAt(i) != '*')
                    return false;
            return true;
        }
        if(p.length() == 0)
            return false;

        p = normalizePattern(p);

        if(p.length() * s.length() < 100000){
            dp = new int[s.length()][p.length()];
            for(int i = 0; i < s.length(); i++){
                for(int j = 0; j < p.length(); j++)
                    dp[i][j] = -1;
            }
        }

        realCharCountInPattern = new int[p.length()];

        int realCount = 0;
        for(int j = p.length() - 1; j >= 0; j--){
            if(p.charAt(j) != '*')
                realCount ++;
            realCharCountInPattern[j] = realCount;
        }

        this.s = s;
        this.p = p;


        return isMatchInner(0, 0);

    }




    private boolean isMatchInner(int si, int pi){


        if(si == s.length()){
            if(pi == p.length())
                return true;

            if(realCharCountInPattern[pi] > 0)
                return false;
            return true;
        }
        if(pi == p.length())
            return false;

        if(s.length() - si < realCharCountInPattern[pi])
            return false;

        if(dp != null && dp[si][pi] != -1)
            return dp[si][pi] == 1;




        boolean res = false;


        if(s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?' || p.charAt(pi) == '*')
            res = isMatchInner(si + 1, pi + 1);

        if(res){
            if(dp != null)
                dp[si][pi] = 1;
            return true;
        }

        if(p.charAt(pi) == '*')
            res = isMatchInner(si + 1, pi) || isMatchInner(si, pi + 1);

        if(res){
            if(dp != null)
                dp[si][pi] = 1;
            return res;
        }

        if(dp != null)
            dp[si][pi] = 0;
        return false;

    }


    public static void main(String[] args){
        WildcardMatching wildcardMatching = new WildcardMatching();
        System.out.println(wildcardMatching.normalizePattern("*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
    }
}
