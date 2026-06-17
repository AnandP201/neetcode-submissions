class DSU {
    int parent[], rank[];

    public DSU(int V) {
        this.parent = new int[V];
        this.rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent[i]);
    }

    public boolean union(int u, int v) {
        int pu = find(u), pv = find(v);

        if (pu == pv)
            return false;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pv] < rank[pu]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
        return true;
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Edges form a tree , if they all connect to form exact 1 component and without any cycle

        int connected = 0;

        DSU dsu = new DSU(n);

        for (int edge[] : edges) {
            int u = edge[0], v = edge[1];
            if (dsu.union(u, v)) {
                connected++;
            } else {
                return false;
            }
        }

        return connected == n - 1;
    }
}
