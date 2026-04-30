class Solution {

    public int dfs(int grid[][], int r, int c){
        if(r==grid.length || r<0 || c==grid[0].length || c<0 || grid[r][c]==0){
            return 0;
        }

        grid[r][c]=0;
        
        int area = 1;

        area += dfs(grid,r+1,c);
        area += dfs(grid,r,c+1);
        area += dfs(grid,r,c-1);
        area += dfs(grid,r-1,c);

        return area;
    }


    public int maxAreaOfIsland(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        int area = 0;

        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]==1){
                    area = Math.max(area,dfs(grid,r,c));
                }
            }
        }

       return area;
    }
}
