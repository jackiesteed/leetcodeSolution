package com.jackiesteed.leetcode;

/**
 * Created by jackie on 4/27/15.
 */
public class JumpGame {

    public boolean canJump(int[] nums) {

        if(nums.length <= 1)
            return true;

        int[] dp = new int[nums.length + 1];

        for(int i = 0; i < nums.length; i++){
            dp[i] = -1;
        }
        dp[nums.length - 1] = 2;
        dp[nums.length] = 1;

        for(int i = nums.length - 2; i >= 0; i--){

            int end = Math.min(i + nums[i] + 1, nums.length);
            int start = i + 1;

            if(end == start){
                dp[i] = dp[i + 1];
                continue;
            }
            if(dp[start] - dp[end] > 0)
                dp[i] = 1 + dp[i + 1];
            else
                dp[i] = dp[i + 1];

        }

        return dp[0] - dp[1] == 1;

    }


    public static void main(String[] args){
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[]{1,2
        }));
    }
}
