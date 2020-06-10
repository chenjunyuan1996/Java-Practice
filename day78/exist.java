/*
面试题12. 矩阵中的路径
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]
但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

链接: https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
*/

class Solution {
    
    public char[][] board;
    public String word;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int k) {
        if (i < 0 || i == this.board.length || j < 0 || j == this.board[i].length || this.board[i][j] != this.word.charAt(k)) return false;
        if (k == this.word.length() - 1) return true;

        char tmp = this.board[i][j];
        this.board[i][j] = '#';
        boolean res = dfs(i-1, j, k+1) || dfs(i+1, j, k+1) || dfs(i, j-1, k+1) || dfs(i, j+1, k+1);
        this.board[i][j] = tmp;
        return res;
    }

}
