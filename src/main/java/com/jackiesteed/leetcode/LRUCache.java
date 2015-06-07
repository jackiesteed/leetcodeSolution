package com.jackiesteed.leetcode;

import java.util.*;

/** An simple implementation of LRUCache
 * Created by jackie on 4/23/15.
 */
public class LRUCache {
    /**
     * the capacity of the cache storage
     */
    private int capacity;

    /**
     * map for fast retrieve
     */
    private Map<Integer, Node> map = new HashMap<Integer, Node>();

    /**
     * head of the cache list
     */
    private Node head = null;

    /**
     * tail of the cache list
     */
    private Node tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * set a cache item
     * @param key
     * @param value
     */
    public void set(int key, int value) {
        //If the key is set in the cache
        if(map.containsKey(key)){
            refreshUsage(key, value);
            return;
        }
        //remove the least recently used item if storage is full
        if(map.size() >= capacity){
            eraseAndSet(key, value);
            return;
        }
        // none of the two above state, insert a new one
        insertNode(key, value);
    }

    /**
     * get a cached item
     * @param key
     * @return
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            Node e = map.get(key);
            if(head != e){
                unlink(e);
                add2Head(e);
            }
            return map.get(key).value;
        }
        return -1;
    }

    /**
     * when the cache storage is full, erase the least recently used, and set the new one
     * @param key
     * @param value
     * @return
     */
    private void eraseAndSet(int key, int value){
        Node e = tail;
        map.remove(e.key);
        e.value = value;
        e.key = key;
        map.put(key, e);
        unlink(e);
        add2Head(e);
    }

    /**
     * If the key exists in the cache, refresh the value and move to head
     * @param key
     * @param value
     * @return
     */
    private void refreshUsage(int key, int value){
        Node e = map.get(key);
        if(head != e){
            unlink(e);
            add2Head(e);
        }
        e.value = value;
    }

    /**
     * when the cache is not full, insert one node
     * @param key
     * @param value
     */
    private void insertNode(int key, int value){
        Node e = new Node(key, value);
        if(head == null || tail == null){
            head = e;
            tail = e;
        }else{
            add2Head(e);
        }
        map.put(key, e);
    }

    /**
     * add node to head
     * @param e
     */
    private void add2Head(Node e){
        e.pre = null;
        e.next = head;
        head.pre = e;
        head = e;
    }

    /**
     * delete the node from the list
     * @param node
     */
    private void unlink(Node node){
        if(node.pre != null)
            node.pre.next = node.next;
        if(node.next != null)
            node.next.pre = node.pre;
        if(tail == node)
            tail = node.pre;
        if(tail == null)
            tail = head;
    }

    /**
     * Node , represents a cache item
     */
    private static class Node {
        private int value;
        private int key;
        private Node next;
        private Node pre;

        /**
         * fully constructor
         * @param value
         * @param key
         * @param next
         * @param pre
         */
        public Node(int value, int key, Node next, Node pre){
            this.value = value;
            this.key = key;
            this.next = next;
            this.pre = pre;
        }

        public Node(int value, int key){
            this(value, key, null, null);
        }
    }

    public void print(){
        Node e = head;
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
