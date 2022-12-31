class Solution {
    public int uniquePathsIII(int[][] grid) {

        int zeroCount = 0;
        int sx = 0, sy = 0;
        // find start cell and zero count in the grid
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0) zeroCount++;
                if(grid[i][j] == 1){
                    sx = i;
                    sy = j;
                }
            }
        }

        return dfs(grid, sx, sy, zeroCount, 0);
    }
    private int dfs(int[][] grid, int sx, int sy, int zeroCount, int currZeroCount){

        //check for out of bound
        if(sx > grid.length - 1 || sy > grid[0].length - 1 || sx < 0 || sy < 0) return 0;
        //check for obstacle
        if(grid[sx][sy] == -1) return 0;
        // destination reached, check if it's a valid  path.
        // it is a valid path zeroCount == currCount - 1.
        // '-1' for extra cell count when we reach destination
        if(grid[sx][sy] == 2 && zeroCount == currZeroCount - 1){
            return 1;
        }
        // destination reached ,But path not valid
        else if(grid[sx][sy] == 2) return 0;

        // mark cell visited
        grid[sx][sy] = -1;

        // move forward in all 4 directions from the current cell
        int totalPaths = dfs(grid, sx + 1, sy, zeroCount, currZeroCount + 1) + 
              dfs(grid, sx, sy + 1, zeroCount, currZeroCount + 1) + 
              dfs(grid, sx - 1, sy, zeroCount, currZeroCount + 1) + 
              dfs(grid, sx, sy - 1, zeroCount, currZeroCount + 1) ;
        
        // backtrack coz base condition false 
        grid[sx][sy] = 0;

    return totalPaths;
    }
}