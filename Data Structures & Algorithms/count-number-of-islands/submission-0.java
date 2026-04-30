class Solution {

    public void dfs(char[][] grid, int r , int c){
        if(r==grid.length || c==grid[0].length || r<0 || c<0 || grid[r][c]=='0'){
            return;
        }

        grid[r][c]='0';

        dfs(grid,r+1,c);
        dfs(grid,r,c+1);
        dfs(grid,r-1,c);
        dfs(grid,r,c-1);
    }

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int islands=0;
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c]=='1'){
                    dfs(grid,r,c);
                    islands++;
                }
            }
        }
        
        return islands;
    }
}
