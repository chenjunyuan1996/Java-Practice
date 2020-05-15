/*
51. N皇后
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens
*/

class Solution {
    private List<List<String>> res = new ArrayList<>();
    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> pie = new HashSet<>();
    private Set<Integer> na = new HashSet<>();
    private int[] board;

    public List<List<String>> solveNQueens(int n) {
        this.board = new int[n];
        DFS(n, 0);
        return this.res;
    }

    private void DFS(int n, int row) {
        if (row >= n) {
            List<String> ans = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                char[] col = new char[n];
                Arrays.fill(col, '.');
                col[board[i]] = 'Q';
                ans.add(String.valueOf(col));
                // ans.add(new String(col));
            }
            this.res.add(ans);
        }

        for (int col = 0; col < n; col++) {
            if (this.cols.contains(col) || this.pie.contains(row + col) || this.na.contains(row - col)) continue;

            this.cols.add(col);
            this.pie.add(row + col);
            this.na.add(row - col);
            board[row] = col;

            DFS(n, ++row);

            row--;
            this.cols.remove(col);
            this.pie.remove(row + col);
            this.na.remove(row - col);
            
        }
    }
}
