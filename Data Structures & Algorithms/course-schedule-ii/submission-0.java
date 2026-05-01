class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        int indegree[] = new int[numCourses];

        for (int edge[] : prerequisites) {
            int u = edge[0], v = edge[1];
            indegree[u]++;
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                q.offer(course);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int courseTook = q.poll();

            ans.add(courseTook);

            for (int n : graph.getOrDefault(courseTook, new ArrayList<>())) {
                if (--indegree[n] == 0) {
                    q.offer(n);
                }
            }
        }

        if(ans.size()!=numCourses){
            return new int[0];
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
