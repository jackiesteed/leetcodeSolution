package com.jackiesteed.leetcode;

/**
 * Created by jackie on 4/24/15.
 */
public class NumberIslands {

    public int numIslands(char[][] grid) {

        if(grid.length == 0)
            return 0;
        if(grid[0].length == 0)
            return 0;

        int res = 0;
        int height = grid.length;
        int width = grid[0].length;

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(grid[i][j] == '1'){
                    res += 1;
                    removeIslands(grid, i, j);
                }
            }
        }
        return res;

    }

    public void removeIslands(char[][] grid, int x, int y){
        grid[x][y] = '0';
        int height = grid.length;
        int width = grid[0].length;

        if(x + 1 < height && grid[x + 1][y] == '1') removeIslands(grid, x + 1, y);
        if(x - 1 >= 0 && grid[x - 1][y] == '1') removeIslands(grid, x - 1, y);
        if(y + 1 < width && grid[x][y + 1] == '1') removeIslands(grid, x, y + 1);
        if(y - 1 >= 0 && grid[x][y - 1] == '1') removeIslands(grid, x, y - 1);

    }
}
