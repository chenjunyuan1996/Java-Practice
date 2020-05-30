# 暴力遍历
# class Solution:
#     def findNumberIn2DArray(self, matrix: List[List[int]], target: int) -> bool:
#         for row in matrix:
#             if target in row:
#                 return True
#         return False


# 从左下方开始搜索
class Solution:
    def findNumberIn2DArray(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]: return False

        rows, cols = len(matrix), len(matrix[0])
        n, m = rows - 1, 0
        while n >= 0 and m < cols:
            if matrix[n][m] == target:
                return True
            elif matrix[n][m] > target:
                n -= 1
            elif matrix[n][m] < target:
                m += 1
        return False


# 剪枝, 从右上开始搜索
# class Solution:
#     def findNumberIn2DArray(self, matrix: List[List[int]], target: int) -> bool:
#         if not matrix or not matrix[0]: return False

#         rows, cols = len(matrix), len(matrix[0])
#         n, m = 0, cols - 1
#         while n < rows and m >=0:
#             if matrix[n][m] == target:
#                 return True
#             elif matrix[n][m] > target:
#                 m -= 1
#             elif matrix[n][m] < target:
#                 n += 1
#         return False
