package com.jackiesteed.leetcode;

import java.util.Stack;

/**
 * Created by fangxue on 15/11/28.
 */
public class FindMedianFromDataStream {

    int[] buffer = new int[1000000];
    int count = 0;


    // Adds a number into the data structure.
    public void addNum(int num) {
        buffer[count++] = num;

        int idx = count - 1;

        while(idx > 0){
            if(buffer[idx - 1] > buffer[idx]){
                int tmp = buffer[idx];
                buffer[idx] = buffer[idx - 1];
                buffer[idx - 1] = tmp;
            }else{
                break;
            }
            idx--;
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(count % 2 == 1){
            return (double) buffer[count / 2];
        }else{
            return (double) (buffer[count / 2] + buffer[count / 2 - 1]) / 2;
        }
    }


    public static void main(String[] args){

        FindMedianFromDataStream findMedianFromDataStream = new FindMedianFromDataStream();
        findMedianFromDataStream.addNum(1);
        findMedianFromDataStream.addNum(2);
        System.out.println(findMedianFromDataStream.findMedian());
    }
}
