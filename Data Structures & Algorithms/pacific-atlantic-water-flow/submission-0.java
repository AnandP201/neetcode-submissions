class Solution {
    int dirs[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public void dfs(int[][] heights, int r, int c, int[][] store) {
        if (store[r][c] == 1)
            return;

        store[r][c]++;

        for (int dir[] : dirs) {
            int nr = dir[0] + r, nc = dir[1] + c;

            // heights[nr][nc] < heights[r][c], means upcoming cell has height less than current
            // while going from ocean to cell , which is not accepted
            if (nr == heights.length || nr < 0 || nc == heights[0].length || nc < 0
                || heights[nr][nc] < heights[r][c])
                continue;

            dfs(heights, nr, nc, store);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;

        int[][] atlantic = new int[rows][cols];
        int[][] pacific = new int[rows][cols];

        // ATLANTIC
        // Bottom Row : Left -> Right
        // rows-1,0 -> rows-1,cols-1
        for (int c = 0; c < cols; c++) {
            dfs(heights, rows - 1, c, atlantic);
        }

        // Right Col : Top -> Bottom
        // 0,cols-1 -> rows-1,cols-1
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, cols - 1, atlantic);
        }

        // PACIFIC
        // Top Row : Left -> Right
        // 0,0 -> 0,cols-1
        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pacific);
        }

        // Left Col : Top -> Bottom
        // 0,0 -> rows-1,0
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pacific);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] == 1 && atlantic[r][c] == 1) {
                    result.add(Arrays.asList(new Integer[] {r, c}));
                }
            }
        }

        return result;
    }
}
