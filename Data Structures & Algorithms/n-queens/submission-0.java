class Solution {
    public boolean canPlace(char[][] grid, int r, int c) {
        int tempRow = r;
        int tempCol = c;

        // same row
        while (c >= 0) {
            if (grid[r][c] == 'Q')
                return false;
            c--;
        }

        r = tempRow;
        c = tempCol;

        // 45deg diagonal
        while (c >= 0 && r >= 0) {
            if (grid[r][c] == 'Q')
                return false;

            r--;
            c--;
        }

        r = tempRow;
        c = tempCol;

        // 135deg diagonal
        while (r < grid.length && c >= 0) {
            if (grid[r][c] == 'Q')
                return false;

            r++;
            c--;
        }

        return true;
    }

    public List<String> construct(char[][] grid) {
        List<String> list = new ArrayList<>();
        for (char[] rows : grid) {
            String row = new String(rows);
            list.add(row);
        }
        return list;
    }

    public void backtrack(char[][] grid, List<List<String>> result, int ROWS, int c) {
        if (c == ROWS) {
            result.add(construct(grid));
            return;
        }

        for (int row = 0; row < ROWS; row++) {
            if (canPlace(grid, row, c)) {
                grid[row][c] = 'Q';
                backtrack(grid, result, ROWS, c + 1);
                grid[row][c] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char board[][] = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(board, result, n, 0);

        return result;
    }
}
