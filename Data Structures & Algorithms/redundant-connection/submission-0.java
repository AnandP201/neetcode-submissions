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
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent[i]);
    }

    public void union(int u, int v) {
        int pu = find(u), pv = find(v);
        if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else if (rank[pv] > rank[pu]) {
            parent[pu] = pv;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int ans[] = new int[2];
        int V = edges.length;

        DSU dsu = new DSU(V + 1);

        for (int edge[] : edges) {
            int u = edge[0], v = edge[1];

            if (dsu.find(u) != dsu.find(v)) {
                dsu.union(u, v);
            } else {
                ans[0] = u;
                ans[1] = v;
            }
        }

        return ans;
    }
}
