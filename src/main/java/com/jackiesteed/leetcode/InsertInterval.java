package com.jackiesteed.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fangxue on 15/11/30.
 */
public class InsertInterval {


    public static class Interval{
        int start;
        int end;
        public Interval(){
            start = 0;
            end = 0;
        }

        public Interval(int s, int e){
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    private Interval merge(Interval a, Interval b){
        Interval res = new Interval();
        res.start = Math.min(a.start, b.start);
        res.end = Math.max(a.end, b.end);
        return res;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> res = new ArrayList<Interval>();

        boolean inserted = false;

        for(Interval interval : intervals){

            if(newInterval.end < interval.start){
                if(!inserted){
                    res.add(newInterval);
                    inserted = true;
                }
                res.add(interval);
            }
            else if(newInterval.end >= interval.start && newInterval.end <= interval.end){
                newInterval = merge(interval, newInterval);
                res.add(newInterval);
                inserted = true;
            }else if(newInterval.start <= interval.end){
                newInterval = merge(interval, newInterval);
            }else{
                res.add(interval);
            }
        }

        if(!inserted){
            res.add(newInterval);
        }
        return res;
    }


    public static void main(String[] args){
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 5));
        System.out.println(new InsertInterval().insert(intervals, new Interval(0,6)));
    }
}
