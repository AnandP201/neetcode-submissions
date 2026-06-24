class DSU {
    int rank[], parent[];

    public DSU(int V) {
        rank = new int[V];
        parent = new int[V];

        for (int i = 0; i < V; i++) {
            rank[i] = 1;
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (i == parent[i])
            return i;
        return parent[i] = find(parent[i]);
    }

    public void union(int u, int v) {
        int pu = find(u), pv = find(v);

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pu] = pv;
            rank[pv]++;
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIdMap = new HashMap<>();
        Map<String, String> emailToNameMap = new HashMap<>();

        int id = 0;

        // Form vertices with email
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToIdMap.containsKey(email)) {
                    emailToIdMap.put(email, ++id);
                    emailToNameMap.put(email, name);
                }
            }
        }

        DSU dsu = new DSU(id + 1);

        // Link emails with edges
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);

            for (int i = 2; i < account.size(); i++) {
                int u = emailToIdMap.get(firstEmail);
                int v = emailToIdMap.get(account.get(i));
                dsu.union(u, v);
            }
        }

        Map<Integer, List<String>> groups = new HashMap<>();

        // Bring all same emails with each other
        // Logic : Email with same parent , group to that parent
        for (String email : emailToIdMap.keySet()) {
            int parent = dsu.find(emailToIdMap.get(email));
            groups.computeIfAbsent(parent, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (List<String> list : groups.values()) {
            String email = list.get(0);

            String name = emailToNameMap.get(email);
            Collections.sort(list);

            List<String> temp = new ArrayList<>();
            temp.add(name);
            temp.addAll(list);

            result.add(temp);
        }

        return result;
    }
}