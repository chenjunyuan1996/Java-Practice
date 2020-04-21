class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) adjacency.add(new ArrayList<>());
        for (int[] cur : prerequisites) {
            degrees[cur[0]]++;
            adjacency.get(cur[1]).add(cur[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre)) {
                if (--degrees[cur] == 0) queue.offer(cur);
            }
        }

        return numCourses == 0;
    }
}
