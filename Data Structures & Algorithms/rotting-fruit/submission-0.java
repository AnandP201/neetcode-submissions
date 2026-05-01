class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    q.offer(new int[] {r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        int mins = 0;
        int dirs[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q.isEmpty()) {
            if (fresh == 0)
                return mins;

            int size = q.size();

            for (int i = 0; i < size; i++) {
                int cell[] = q.poll();
                int r = cell[0], c = cell[1];

                for (int dir[] : dirs) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr == grid.length || nc == grid[0].length || nr < 0 || nc < 0
                        || grid[nr][nc] == 0 || grid[nr][nc] == 2)
                        continue;

                    grid[nr][nc] = 2;
                    q.offer(new int[] {nr, nc});
                }
            }

            if (!q.isEmpty()) {
                mins++;
            }
        }

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    return -1;
                }
            }
        }

        return mins;
    }
}
