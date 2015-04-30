package com.jackiesteed.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jackie on 4/25/15.
 */
public class PermutationsII {



    public List<List<Integer>> permuteUnique(int[] num) {

        Arrays.sort(num);


        List<List<Integer>> res = new ArrayList<List<Integer>>();

        res.add(getListFromArray(num));
        while(nextPermutation(num)) {
            res.add(getListFromArray(num));
//            System.out.println(res);

        }

        return res;

    }

    private List<Integer> getListFromArray(int[] num){
        List<Integer> res = new ArrayList<Integer>();
        for(Integer i : num)
            res.add(i);
        return res;
    }

    public boolean nextPermutation(int[] num){
        int len = num.length;
        int pivot = len;

        for(int i = len - 1; i > 0; i--){
            if(num[i - 1] < num[i]){
                pivot = i - 1;
                break;
            }
        }
        if(pivot == len)
            return false;
        for(int i = len - 1; i > pivot; i--){
            if(num[i] > num[pivot]){
                swap(i, pivot, num);
                break;
            }
        }


        int start = pivot + 1;
        int end = len - 1;
        while(start < end){
            swap(start, end, num);
            start ++;
            end --;
        }

        return true;


    }

    public void swap(int i, int j, int[] num){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args){
        PermutationsII permutationsII = new PermutationsII();
        System.out.println(permutationsII.permuteUnique(new int[]{2,2,1,1}));
    }
}
