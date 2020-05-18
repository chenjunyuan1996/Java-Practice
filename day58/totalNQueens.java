/*
52. N皇后 II
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给定一个整数 n，返回 n 皇后不同的解决方案的数量。

链接：https://leetcode-cn.com/problems/n-queens-ii/
*/

class Solution {
    public int res = 0;

    public int totalNQueens(int n) {
        dfs(0, n, 0, 0, 0);
        return this.res;
    }

    private void dfs(int row, int n, int col, int pie, int na) {
        if (row == n) {
            this.res++;
            return;
        }

        int bits = (~(col | pie | na)) & ((1 << n) - 1);
        while (bits > 0) {
            // 取最右的1，负数以补码的形式表示
            int p = bits & -bits; 
            dfs(row + 1, n, col | p, (pie | p) << 1, (na | p) >> 1);
            bits &= bits - 1;
        }
    }
}
