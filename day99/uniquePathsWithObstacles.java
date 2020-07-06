class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        int[] res = new int[n + 1];
        res[1] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[j + 1] = 0;
                } else {
                    res[j + 1] += res[j];
                }
            }
        }
        return res[n];
        
    }
}
