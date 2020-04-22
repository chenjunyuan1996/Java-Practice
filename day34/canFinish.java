class Solution {

    private boolean dfs(int i, List<Integer> adjacency[], int[] flags) {
            if (flags[i] == -1) return true;
            if (flags[i] == 1) return false;
            flags[i] = 1;
            for (int j : adjacency[i]) {
                if (!dfs(j, adjacency, flags)) return false;
            }
            flags[i] = -1;
            return true;
        }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] flags = new int[numCourses];
        List<Integer> adjacency[] = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) adjacency[i] = new ArrayList<>();
        for (int[] cur : prerequisites) adjacency[cur[1]].add(cur[0]);

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, adjacency, flags)) return false;
        }

        return true;
    }
}
