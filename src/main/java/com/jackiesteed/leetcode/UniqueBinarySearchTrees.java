package com.jackiesteed.leetcode;

/**
 * Created by jackie on 4/19/15.
 */
public class UniqueBinarySearchTrees {

    java.util.Map<Integer, Integer> map = new java.util.HashMap<Integer, Integer>();



    //catalan
    public int numTrees(int n) {



        if(n == 1 || n == 0)
            return 1;

        int res = 0;

        if(map.containsKey(n))
            return map.get(n);

        for(int i = 0; i < n; i ++){
            res += numTrees(i) * numTrees(n - i - 1);
        }
        map.put(n, res);
        return res;

    }




}
