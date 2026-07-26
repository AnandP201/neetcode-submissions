class Solution {
    public int dfs(int r, int c, int grid[][], Integer memo[][]) {
        if (r == grid.length || c == grid[0].length || grid[r][c] == 1)
            return 0;

        if (r == grid.length - 1 && c == grid[0].length - 1)
            return 1;

        if (memo[r][c] != null)
            return memo[r][c];

        return memo[r][c] = dfs(r + 1, c, grid, memo) + dfs(r, c + 1, grid, memo);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Integer memo[][] = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return dfs(0, 0, obstacleGrid, memo);
    }
}