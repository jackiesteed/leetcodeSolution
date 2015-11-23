package com.jackiesteed.leetcode;

/**
 * Created by jackie on 5/1/15.
 */
public class MedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        int[] num = new int[m + n];


        int medianPos = (m + n) / 2;
        int mIdx = 0;
        int nIdx = 0;
        int totalIdx = 0;
        while(true){
            if(totalIdx >= m + n)
                break;
            if(mIdx >= m)
                num[totalIdx++] = nums2[nIdx++];
            else if(nIdx >= n)
                num[totalIdx++] = nums1[mIdx++];
            else{
                if(nums1[mIdx] < nums2[nIdx])
                    num[totalIdx++] = nums1[mIdx++];
                else
                    num[totalIdx++] = nums2[nIdx++];

            }
        }

        if((m + n )% 2 == 0){
            return (double)(num[(m + n) / 2] + num[(m + n) / 2 - 1]) / 2;
        }
        return num[(m + n) / 2];


    }

    public static void  main(String[] args){

        System.out.println(findMedianSortedArrays(new int[]{3,4}, new int[]{}));

    }




}
