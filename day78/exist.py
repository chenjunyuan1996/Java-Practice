class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def recursion(i, j, k):
            if i < 0 or i == len(board) or j < 0 or j == len(board[i]) or board[i][j] != word[k]: return False
            if k == len(word) - 1: return True
            
            tmp = board[i][j]
            board[i][j] = "#"
            res = recursion(i-1, j, k+1) or recursion(i+1, j, k+1) or recursion(i, j-1, k+1) or recursion(i, j+1, k+1)
            board[i][j] = tmp
            return res

        for i in range(len(board)):
            for j in range(len(board[i])):
                if recursion(i, j, 0):
                    return True
        return False


# class Solution:
#     def exist(self, board: List[List[str]], word: str) -> bool:
#         if not word:
#             return True
#         self.dx = [-1, 1, 0, 0]
#         self.dy = [0, 0, -1, 1]

#         for i in range(len(board)):
#             for j in range(len(board[i])):
#                 if board[i][j] == word[0] and self.recursion(board, word[1:], i, j):
#                     return True
#         return False


#     def recursion(self, board, word, x, y):
#         if not word or len(word) == 0:
#             return True

#         tmp = board[x][y]
#         board[x][y] = "#"
        
#         for t in range(4):
#             xt = x + self.dx[t]
#             yt = y + self.dy[t]
#             if 0 <= xt < len(board) and 0 <= yt < len(board[x]) and board[xt][yt] == word[0] and self.recursion(board, word[1:], xt, yt):
#                 return True
#         board[x][y] = tmp
#         return False
