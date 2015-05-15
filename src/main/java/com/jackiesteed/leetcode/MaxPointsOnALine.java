package com.jackiesteed.leetcode;

/**
 * Created by jackie on 5/2/15.
 */
public class MaxPointsOnALine {

    private static class Point {
             int x;
             int y;
             Point() { x = 0; y = 0; }
             Point(int a, int b) { x = a; y = b; }
         }

    private boolean isLine(Point a, Point b, Point c){
        if((a.x - b.x) * (b.y - c.y) == (a.y - b.y) * (b.x - c.x))
            return true;
        return false;
    }

    private boolean isSamePoint(Point a, Point b){
        return a.x == b.x && a.y == b.y;
    }


    public int maxPoints(Point[] points) {


        if(points.length <= 2)
            return points.length;


        int res = 2;


        for(int i = 0; i < points.length; i++){

            int duplicated = 0;

            for(int j = i + 1; j < points.length; j++){
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    duplicated ++;
                }
            }

            if(duplicated == points.length - 1 - i){
                res = Math.max(res, duplicated + 1);
                break;
            }

            int temp4i = 2;

            for(int j = i + 1; j < points.length; j++){
                if(isSamePoint(points[i], points[j])){
                    continue;
                }
                int temp = 2;
                for(int k = j + 1; k < points.length; k++){

                    if(isSamePoint(points[i], points[k]))
                        continue;

                    if(isLine(points[i], points[j], points[k]))
                        temp ++;
                }


                temp4i = Math.max(temp4i, temp);
            }
            res = Math.max(res, duplicated + temp4i);
        }

        return res;
    }

    public static void main(String[] args){
        Point[] array = new Point[]{new Point(0,0), new Point(1,1), new Point(0, 0)};
        System.out.println(new MaxPointsOnALine().maxPoints(array));

        System.out.println(new MaxPointsOnALine().isLine(new Point(0,0), new Point(1,1), new Point(1, -1)));
    }


}
