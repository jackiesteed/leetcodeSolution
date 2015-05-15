package com.jackiesteed.leetcode;

/**
 * Created by jackie on 4/30/15.
 */
public class Candy {





    public static int candy(int[] ratings){

        int[] res = new int[ratings.length];

        for(int i = 0; i < ratings.length; i++)
            res[i] = 1;

        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]) res[i] = res[i - 1] + 1;
        }

        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]) res[i] = Math.max(res[i + 1] + 1, res[i]);
        }

        int total = 0;
        for(int candy : res){
            total += candy;
        }

        return total;

    }

}
