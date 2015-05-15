package com.jackiesteed.leetcode;

/**
 * Created by jackie on 5/3/15.
 */
public class TrappingRainWater {

    public int trap(int[] height) {

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int res = -1;
        for(int i = 0; i < height.length; i++){
            if(res < height[i])
                res = height[i];
            leftMax[i] = res;
        }
        res = -1;
        for(int j = height.length - 1; j >= 0; j--){
            if(res < height[j])
                res = height[j];
            rightMax[j] = res;
        }

        res = 0;

        for(int i = 0; i < height.length; i++){
            int maxTrap = Math.min(leftMax[i], rightMax[i]);
            if(maxTrap > height[i])
                res += maxTrap - height[i];
        }

        return res;

    }


    public static void main(String[] args){
        System.out.println(new TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }


}
