class Solution {
    public boolean dfs(int course, int state[], Map<Integer, List<Integer>> graph) {
        if (state[course] != 0)
            return state[course] == 1;

        state[course] = 1;

        for (int n : graph.getOrDefault(course, new ArrayList<>())) {
            if (dfs(n, state, graph)) {
                return true;
            }
        }

        state[course] = 2;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int edge[] : prerequisites) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        int[] state = new int[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (dfs(course, state, graph)) {
                return false;
            }
        }

        return true;
    }
}
