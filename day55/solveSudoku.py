class Solution:
    
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.solve(board)
    
    def solve(self, board):
        for i in range(9):
            for j in range(9):
                if board[i][j] != ".": continue
                
                for k in range(1, 10):
                    if self.isValid(board, i, j, str(k)):
                        board[i][j] = str(k)
                        if self.solve(board): return True
                        board[i][j] = "."
                return False
                
        return True

    def isValid(self, board, row, col, num):
        r = row // 3 * 3
        c = col // 3 * 3
        for i in range(9):
            if board[i][col] == num: return False
            if board[row][i] == num: return False
            if board[r + i // 3][c + i % 3] == num: return False
        return True
