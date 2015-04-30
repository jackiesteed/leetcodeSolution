package com.jackiesteed.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackie on 4/23/15.
 */
public class GrayCode {


    public static List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> res = new ArrayList<Integer>();
            res.add(0);
            return res;
        }

        if (n == 1) {
            List<Integer> res = new ArrayList<Integer>();
            res.add(0);
            res.add(1);
            return res;
        }
        List<Integer> recursiveRes = grayCode(n - 1);
        List<Integer> res = new ArrayList<Integer>();
        for (Integer i : recursiveRes) {
            res.add(i);
        }
        int len = recursiveRes.size();
        for (int i = len - 1; i >= 0; i--) {
            res.add((1 << (n - 1)) + recursiveRes.get(i));
        }
        return res;
    }


    public static void main(String[] args){
        System.out.println(grayCode(2));
    }
}
