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

    public void backtrack(char[][] grid, List<List<String>> result, int col, boolean ROWS[],
        boolean DIAG[], boolean ADIAG[]) {
        if (col == grid.length) {
            result.add(construct(grid));
            return;
        }

        for (int row = 0; row < grid.length; row++) {
            if (ROWS[row] || ADIAG[row + col] || DIAG[row - col + (grid.length - 1)])
                continue;

            ROWS[row] = true;
            ADIAG[row + col] = true;
            DIAG[row - col + grid.length - 1] = true;

            grid[row][col] = 'Q';

            backtrack(grid, result, col + 1, ROWS, DIAG, ADIAG);

            grid[row][col] = '.';

            ROWS[row] = false;
            ADIAG[row + col] = false;
            DIAG[row - col + grid.length - 1] = false;

            // if (canPlace(grid, row, c)) {
            //     grid[row][c] = 'Q';
            //     backtrack(grid, result, ROWS, c + 1);
            //     grid[row][c] = '.';
            // }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char board[][] = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean ROWS[] = new boolean[n];
        boolean DIAG[] = new boolean[2 * n - 1];
        boolean ADIAG[] = new boolean[2 * n - 1];

        backtrack(board, result, 0, ROWS, DIAG, ADIAG);

        return result;
    }
}
