class Solution {
    public void capture(char board[][], int r, int c) {
        if (r < 0 || c < 0 || r == board.length || c == board[0].length || board[r][c] != 'O')
            return;

        board[r][c] = 'E';

        capture(board, r + 1, c);
        capture(board, r, c + 1);
        capture(board, r, c - 1);
        capture(board, r - 1, c);
    }

    public void solve(char[][] board) {
        int ROWS = board.length, COLS = board[0].length;

        // CAPTURE BORDER CONNECTED REGIONS
        for (int r = 0; r < ROWS; r++) {
            if (board[r][0] == 'O') {
                capture(board, r, 0);
            }
            if (board[r][COLS - 1] == 'O') {
                capture(board, r, COLS - 1);
            }
        }

        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == 'O') {
                capture(board, 0, c);
            }
            if (board[ROWS - 1][c] == 'O') {
                capture(board, ROWS - 1, c);
            }
        }
        // END CAPTURE BORDER

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'E') {
                    board[r][c] = 'O';
                }
            }
        }
    }
}
