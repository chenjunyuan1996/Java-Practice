/*
200. 岛屿数量
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。

链接: https://leetcode-cn.com/problems/number-of-islands/
*/

class Solution {
    char[][] g;
    public int numIslands(char[][] grid) {
        int islands = 0;
        g = grid;
        for (int i=0; i<g.length; i++) {
            for (int j=0; j<g[i].length; j++) {
                islands += sink(i, j);
            }
        }
        return islands;
    }

    int sink(int i, int j) {
        if (i < 0 || i == g.length || j < 0 || j == g[i].length || g[i][j] == '0')
            return 0;
        g[i][j] = '0';
        sink(i+1, j); sink(i-1, j); sink(i, j+1); sink(i, j-1);
        return 1;
    }
}

// class Solution {
//     public int numIslands(char[][] grid) {
//         int res = 0;
//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[i].length; j++) {
//                 if (grid[i][j] == '1') {
//                     res++;
//                     Queue<List<Integer>> queue = new LinkedList<>();
//                     queue.offer(Arrays.asList(i, j));
//                     grid[i][j] = '0';
//                     while (!queue.isEmpty()) {
//                         List<Integer> location = queue.poll();
//                         int m = location.get(0), n = location.get(1);
//                         if (m - 1 >= 0 && grid[m - 1][n] == '1') {
//                             queue.offer(Arrays.asList(m - 1, n));
//                             grid[m - 1][n] = '0';
//                         }
//                         if (m + 1 < grid.length && grid[m + 1][n] == '1') {
//                             queue.offer(Arrays.asList(m + 1, n));
//                             grid[m + 1][n] = '0';
//                         }
//                         if (n - 1 >= 0 && grid[m][n - 1] == '1') {
//                             queue.offer(Arrays.asList(m, n - 1));
//                             grid[m][n - 1] = '0';
//                         }
//                         if (n + 1 < grid[m].length && grid[m][n + 1] == '1') {
//                             queue.offer(Arrays.asList(m, n + 1));
//                             grid[m][n + 1] = '0';
//                         }
//                     }
//                 }
//             }
//         }
//         return res;
        
//     }
// }

// class Solution {
//     public int numIslands(char[][] grid) {
//         int res = 0;
//         int[][] move = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[i].length; j++) {
//                 if (grid[i][j] == '1') {
//                     res++;
//                     Queue<Integer[]> queue = new LinkedList<>();
//                     queue.offer(new Integer[]{i, j});
//                     grid[i][j] = '0';
//                     while (!queue.isEmpty()) {
//                         Integer[] location = queue.poll();
//                         int m = location[0], n = location[1];
//                         for (int[] step : move) {
//                             int dm = step[0], dn = step[1];
//                             if (0 <= m + dm && m + dm < grid.length && 0 <= n + dn && n + dn < grid[m].length && grid[m + dm][n + dn] == '1') {
//                                 queue.offer(new Integer[]{m + dm, n + dn});
//                                 grid[m + dm][n + dn] = '0';
//                             }
//                         }
//                     }
//                 }
//             }
//         }
//         return res;
        
//     }
// }
