class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }
        
        int[][] orient = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int i = point[0], j = point[1];
            for (int k = 0; k < 4; k++) {
                int ni = i + orient[k][0], nj = j + orient[k][1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && matrix[ni][nj] == -1) { 
                    matrix[ni][nj] = matrix[i][j] + 1;
                    queue.offer(new int[]{ni, nj});
                }
            }
        }

        return matrix;
    }
}
