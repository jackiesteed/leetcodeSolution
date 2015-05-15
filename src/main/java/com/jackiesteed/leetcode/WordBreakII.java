package com.jackiesteed.leetcode;

import java.util.*;

/**
 * Created by jackie on 5/1/15.
 */
public class WordBreakII {

    private class Node{
        boolean isEnd = false;
        Map<Character, Node> children = new HashMap<Character, Node>();
    }

    private int sLen = 0;
    private Map<Integer, List<String>> matchMap = new HashMap<Integer, List<String>>();
    private List<String> resList = new ArrayList<String>();
    boolean[] reachEnd;

    public void work(String temp, int start){



        System.out.println(temp);
        if(start == sLen){
            resList.add(temp);
            return;
        }

        if(!reachEnd[start])
            return;

        for(String matchWord : matchMap.get(start)){
            int nextStart = start + matchWord.length();
            if(nextStart == sLen || matchMap.containsKey(nextStart)){

                work(temp.length() == 0 ? matchWord : temp + " " + matchWord, nextStart);
            }
        }

    }





    public List<String> wordBreak(String s, Set<String> wordDict) {

        sLen = s.length();
        Node root = new Node();
        for(String word : wordDict){
            Node cur = root;
            for(char c : word.toCharArray()){
                if(cur.children.containsKey(c)){
                    cur = cur.children.get(c);
                    continue;
                }
                Node next = new Node();
                cur.children.put(c, next);
                cur = next;
            }
            cur.isEnd = true;
        }

//        System.out.println("here");



        for(int i = 0; i < s.length(); i++){
            Node cur = root;
            StringBuilder tempBuilder = new StringBuilder();
            for(int j = i; j <= s.length(); j++){
                if(cur.isEnd){
                    if(!matchMap.containsKey(i))
                        matchMap.put(i, new ArrayList<String>());
                    matchMap.get(i).add(tempBuilder.toString());
                }
                if(j == s.length())
                    break;
                if(cur.children.containsKey(s.charAt(j))){
                    cur = cur.children.get(s.charAt(j));
                    tempBuilder.append(s.charAt(j));
                }else{
                    break;
                }

            }
        }

//        for(Map.Entry<Integer, List<String>> entry : matchMap.entrySet()){
//            System.out.println(entry.getKey());
//            System.out.println(":" + entry.getValue());
//        }

        reachEnd = new boolean[s.length()];
        for(int i = s.length() - 1; i >= 0; i--){
            if(!matchMap.containsKey(i)){
                reachEnd[i] = false;
                continue;
            }
            for(String matchWord : matchMap.get(i)){
                int j = i + matchWord.length();
                if(j == s.length() || reachEnd[j]){
                    reachEnd[i] = true;
                    break;
                }
            }
        }

        work("", 0);

        return resList;

    }

    public static void main(String[] args){
        WordBreakII wordBreakII = new WordBreakII();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        Set<String> set = new HashSet<String>();
//        set.add("a");
//        set.add("b");

        for(String temp : new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}){
            set.add(temp);
        }
        System.out.println(wordBreakII.wordBreak(s, set));
    }
}
