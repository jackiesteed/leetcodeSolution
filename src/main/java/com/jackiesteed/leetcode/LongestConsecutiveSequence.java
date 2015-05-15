package com.jackiesteed.leetcode;

import java.util.Arrays;

/**
 * Created by jackie on 5/10/15.
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        if(nums.length == 0)
            return 0;


        int negativeCount = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0)
                negativeCount ++;
        }
        int[] negativeArray = new int[negativeCount];

        int[] nonNegativeArray = new int[nums.length - negativeCount];

        int negIndex = 0;
        int nonNegIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0)
                negativeArray[negIndex++] = -nums[i];
            else
                nonNegativeArray[nonNegIndex++] = nums[i];
        }

        radixSort(negativeArray, 10, 9);
        radixSort(nonNegativeArray, 10, 9);

        int index = 0;
        for(int i = negativeArray.length - 1; i >= 0; i--){
            nums[index++] = -negativeArray[i];
        }
        for(int i = 0; i < nonNegativeArray.length; i++){
            nums[index++] = nonNegativeArray[i];
        }

        int res = 1;
        int temp = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1] + 1)
                temp ++;
            else if(nums[i] == nums[i - 1])
                continue;
            else
                temp = 1;
            res = Math.max(res, temp);
        }

        return res;

    }


    public static void radixSort(int[] data, int radix, int d) {
        // 缓存数组
        int[] tmp = new int[data.length];
        // buckets用于记录待排序元素的信息
        // buckets数组定义了max-min个桶
        int[] buckets = new int[radix];

        for (int i = 0, rate = 1; i < d; i++) {

            // 重置count数组，开始统计下一个关键字
            Arrays.fill(buckets, 0);
            // 将data中的元素完全复制到tmp数组中
            System.arraycopy(data, 0, tmp, 0, data.length);

            // 计算每个待排序数据的子关键字
            for (int j = 0; j < data.length; j++) {
                int subKey = (tmp[j] / rate) % radix;
                buckets[subKey]++;
            }

            for (int j = 1; j < radix; j++) {
                buckets[j] = buckets[j] + buckets[j - 1];
            }

            // 按子关键字对指定的数据进行排序
            for (int m = data.length - 1; m >= 0; m--) {
                int subKey = (tmp[m] / rate) % radix;
                data[--buckets[subKey]] = tmp[m];
            }
            rate *= radix;
        }

    }

    public static void main(String[] args){
        new LongestConsecutiveSequence().longestConsecutive(new int[]{0});
    }
}
