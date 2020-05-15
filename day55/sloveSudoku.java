/*
37. 解数独
编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sudoku-solver
*/

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) for (int j = 0; j < 9; j++) {
            if (board[i][j] != '.') continue;
            for (char c = '1'; c <= '9'; c++) {
                if (isValid(board, i, j, c)) {
                    board[i][j] = c;
                    if (solve(board)) return true;
                    board[i][j] = '.';
                }
            }
            return false;
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char n) {
        int r = row / 3 * 3;
        int c = col / 3 * 3;
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == n) return false;
            if (board[i][col] == n) return false;
            if (board[r + i / 3][c + i % 3] == n) return false;
        }
        return true;
    }
}
