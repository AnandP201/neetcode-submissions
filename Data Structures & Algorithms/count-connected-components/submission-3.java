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
        if (i == parent[i])
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
            parent[pu] = pv;
            rank[pv]++;
        }
        return true;
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        int components = n;

        DSU dsu = new DSU(n);

        for (int edge[] : edges) {
            int u = edge[0], v = edge[1];

            if (dsu.union(u, v)) {
                components--;
            }
        }

        return components;
    }
}
