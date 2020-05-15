class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row = [{} for _ in range(9)]
        col = [{} for _ in range(9)]
        box = [{} for _ in range(9)]

        for i in range(9):
            for j in range(9):
                if board[i][j] == ".": continue
                
                num = board[i][j]
                k = i // 3 * 3 + j // 3
                row[i][num] = row[i].get(num, 0) + 1
                col[j][num] = col[j].get(num, 0) + 1
                box[k][num] = box[k].get(num, 0) + 1

                if row[i][num] > 1 or col[j][num] > 1 or box[k][num] > 1: return False
                
        return True

# class Solution:
#     def isValidSudoku(self, board: List[List[str]]) -> bool:
#         row = [set() for _ in range(9)]
#         col = [set() for _ in range(9)]
#         box = [[set() for i in range(3)] for j in range(3)]

#         for i in range(9):
#             for j in range(9):
#                 if board[i][j] == ".": continue
                
#                 cur = board[i][j]
#                 if cur not in row[i]: row[i].add(cur)
#                 else: return False

#                 if cur not in col[j]: col[j].add(cur)
#                 else: return False

#                 if cur not in box[i // 3][j // 3]: box[i // 3][j // 3].add(cur)
#                 else: return False

#         return True
