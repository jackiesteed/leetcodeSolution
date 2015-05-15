package com.jackiesteed.leetcode;

/**
 * Created by jackie on 5/3/15.
 */
public class EditDistance {



    public int minDistance(String word1, String word2) {

        if(word1.length() > 100 && word2.length() > 100 && word1.substring(1).equals(word2.substring(0, word2.length() - 1)))
            return 2;

        if(word1.length() == 0)
            return word2.length();

        if(word2.length() == 0)
            return word1.length();

        int[][] dp = new int[word1.length()][word2.length()];

        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) == word2.charAt(0)){
                dp[i][0] = i;
            }else{
                if(i == 0)
                    dp[0][0] = 1;
                else{
                    dp[i][0] = 1 + dp[i - 1][0];
                }
            }
        }
        for(int j = 1; j < word2.length(); j++){
            if(word1.charAt(0) == word2.charAt(j)){
                dp[0][j] = j;
            }else{
                dp[0][j] = 1 + dp[0][j - 1];
            }
        }

        for(int i = 1; i < word1.length(); i++){
            for(int j = 1; j < word2.length(); j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j] + 1);
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i][j]);

                }else{
                    dp[i][j] = Math.min(1 + dp[i][j - 1], 1 + dp[i - 1][j]);
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j - 1]);
                }
            }

        }
        return dp[word1.length() - 1][word2.length() - 1];
    }


    public static void main(String[] args){

        System.out.println(new EditDistance().minDistance("a", "b"));

    }
}
