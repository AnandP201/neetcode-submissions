class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    q.offer(new int[] {r, c});
                }
            }
        }

        int dirs[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int p[] = q.poll();

                int r = p[0], c = p[1];

                for (int dir[] : dirs) {
                    int nr = dir[0] + r;
                    int nc = dir[1] + c;

                    if (nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0
                        && grid[nr][nc] == Integer.MAX_VALUE) {
                        q.offer(new int[] {nr, nc});
                        grid[nr][nc] = level;
                    }
                }
            }
            level++;
        }
    }
}
