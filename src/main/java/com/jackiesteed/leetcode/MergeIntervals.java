package com.jackiesteed.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackie on 5/3/15.
 */
public class MergeIntervals {

    public class Interval {
            int start;
             int end;
             Interval() { start = 0; end = 0; }
             Interval(int s, int e) { start = s; end = e; }
         }

    private boolean isIntersect(Interval a, Interval b){
        if(a.end >= b.start && a.end <= b.end)
            return true;

        if(a.start >= b.start && a.start <= b.end)
            return true;

        if(b.start >= a.start && b.start <= a.end)
            return true;

        if(b.end >= a.start && b.end <= a.end)
            return true;

        return false;
    }

    private Interval merge2Interval(Interval a, Interval b){
        int start = Math.min(a.start, b.start);
        int end = Math.max(a.end, b.end);

        return new Interval(start, end);
    }

    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> res = new ArrayList<Interval>();

        int len = intervals.size();

        for(int i = 0; i < len; i++){
            Interval interval = intervals.get(i);
            boolean bingo = false;
            for(int j = i + 1; j < len; j++){

                Interval interval1 = intervals.get(j);

                if(isIntersect(interval, interval1)){
                    Interval merged = merge2Interval(interval, interval1);
                    bingo = true;
                    interval1.start = merged.start;
                    interval1.end = merged.end;
                }
            }
            if(!bingo)
                res.add(interval);
        }

        return res;
    }

}
