class DSU {
    int parent[], rank[];

    public DSU(int V) {
        parent = new int[V];
        rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int u) {
        if (u == parent[u])
            return u;
        return parent[u] = find(parent[u]);
    }

    public void union(int u, int v) {
        int pu = find(u), pv = find(v);

        if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else {
            parent[pu] = pv;
            rank[pv]++;
        }
    }

    public boolean isConnected(int u, int v) {
        return find(u) == find(v);
    }
}

class Solution {
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        int DIRS[][] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        DSU dsu = new DSU(ROWS * COLS + 1);

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] != 'O')
                    continue;
                if (r == 0 || c == 0 || r == ROWS - 1 || c == COLS - 1) {
                    // this is border
                    if (board[r][c] == 'O') {
                        dsu.union(ROWS * COLS, r * COLS + c);
                    }
                } else {
                    for (int dir[] : DIRS) {
                        int nr = dir[0] + r;
                        int nc = dir[1] + c;

                        if (board[nr][nc] == 'O') {
                            dsu.union(r * COLS + c, nr * COLS + nc);
                        }
                    }
                }
            }
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (!dsu.isConnected(ROWS * COLS, r * COLS + c)) {
                    board[r][c] = 'X';
                }
            }
        }
    }
}
