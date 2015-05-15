package com.jackiesteed.leetcode;

/**
 * Created by jackie on 5/1/15.
 */
public class MedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int medianPos = (m + n) / 2;
        int mIdx = 0;
        int nIdx = 0;
        int totalIdx = 0;
        while(true){

            if(totalIdx == medianPos)
                break;

            if(mIdx < m && nIdx < n){

            }
        }

        return 0.0;
    }
}
