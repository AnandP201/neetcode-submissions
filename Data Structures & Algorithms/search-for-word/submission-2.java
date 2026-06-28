class Solution {
    boolean dfs(char[][] board, int r, int c, int idx, String word) {
        if (idx == word.length())
            return true;

        if (r == board.length || c == board[0].length || r < 0 || c < 0
            || board[r][c] != word.charAt(idx) || board[r][c] == '#')
            return false;

        board[r][c] = '#';

        boolean exists = dfs(board, r + 1, c, idx + 1, word) || dfs(board, r, c + 1, idx + 1, word)
            || dfs(board, r - 1, c, idx + 1, word) || dfs(board, r, c - 1, idx + 1, word);

        board[r][c] = word.charAt(idx);

        return exists;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(board, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
