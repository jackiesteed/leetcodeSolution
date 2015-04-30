package com.jackiesteed.leetcode;

/**
 * Created by jackie on 4/19/15.
 */
public class NumberOf1Bits {

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {

        long ss = getUnsignedIntt(n);


        int res = 0;
        while(ss > 0){
            if((ss & 1) > 0){
                res ++;
            }
            ss /= 2;
        }
        return res;

    }

    public static long getUnsignedIntt (int data){     //将int数据转换为0~4294967295 (0xFFFFFFFF即DWORD)。
        return data&0x0FFFFFFFF ;
    }

    public static void main(String[] args){
//        System.out.println(hammingWeight(2147483648L));
    }



}
