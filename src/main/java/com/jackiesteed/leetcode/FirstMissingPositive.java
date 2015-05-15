package com.jackiesteed.leetcode;

/**
 * Created by jackie on 5/2/15.
 */
public class FirstMissingPositive {


    private int[] array;

    private void swap(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int firstMissingPositive(int[] nums) {
        array = nums;

        for(int i = 0; i < nums.length; i++) {

            int j = i;

            while (true) {
                if (nums[j] == j + 1) {
                    break;
                }
                if (nums[j] > nums.length || nums[j] <= 0) {
                    nums[j] = -1;
                    break;
                }
                int temp = nums[nums[j] - 1];
                if(temp == nums[j])
                    break;

                swap(j, nums[j] - 1);
            }

        }

//        for(int i = 0; i < nums.length; i++){
//            System.out.print(nums[i] + ", ");
//        }
//        System.out.println("");


        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;



    }


    public static void  main(String[] args){
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{1,1}));
    }
}
