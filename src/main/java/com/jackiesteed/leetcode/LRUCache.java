package com.jackiesteed.leetcode;

import java.util.*;

/**
 * Created by jackie on 4/23/15.
 */
public class LRUCache {

    private int capacity;

    private Map<Integer, Ele> map = new HashMap<Integer, Ele>();

    private Ele head = null;

    private Ele tail = null;


    public LRUCache(int capacity) {
        this.capacity = capacity;
    }


    public void set(int key, int value) {
        if(map.containsKey(key)){
            Ele e = map.get(key);
            if(head != e){
                unlink(e);
                add2Head(e);
            }
            e.value = value;
            return;
        }
        if(map.size() >= capacity){
            Ele e = tail;
            map.remove(e.key);
            e.value = value;
            e.key = key;
            map.put(key, e);
            unlink(e);
            add2Head(e);
            return;
        }
        Ele e = new Ele();
        e.key = key;
        e.value = value;
        e.pre = null;
        e.next = null;

        if(head == null || tail == null){
            head = e;
            tail = e;
        }else{
            add2Head(e);
        }


        map.put(key, e);
    }

    private void add2Head(Ele e){
        e.pre = null;
        e.next = head;
        head.pre = e;
        head = e;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Ele e = map.get(key);
            if(head != e){
                unlink(e);
                add2Head(e);
            }
            return map.get(key).value;
        }
        return -1;
    }

    private void unlink(Ele e){

        if(e.pre != null)
            e.pre.next = e.next;
        if(e.next != null)
            e.next.pre = e.pre;

        if(tail == e)
            tail = e.pre;

        if(tail == null)
            tail = head;
    }

    static class Ele {
        private int value;
        private int key;
        private Ele next;
        private Ele pre;
    }

    public void print(){
        Ele e = head;
        while(true){
            if(e == null)
                break;
            System.out.print("(" + e.key + "," + e.value + "),");
            e = e.next;
        }

        System.out.println("");
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(3);
        cache.set(1,1);
        cache.set(2, 2);
        cache.set(3,3);
        cache.set(4,4);
        cache.print();
        cache.get(4);
        cache.get(3);
        cache.get(2);
        cache.get(1);
        cache.print();


    }
}
