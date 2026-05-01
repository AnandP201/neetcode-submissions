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

    public int find(int i) {
        if (i == parent[i])
            return i;
        return parent[i] = find(parent[i]);
    }

    public void union(int u, int v) {
        int pu = find(u), pv = find(v);

        if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int connected = 0;
        for (int edge[] : edges) {
            int u = edge[0], v = edge[1];
            if (dsu.find(u) != dsu.find(v)) {
                dsu.union(u, v);
                connected++;
            }
        }

        return n - connected;
    }
}
