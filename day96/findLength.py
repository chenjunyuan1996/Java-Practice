"""
718. 最长重复子数组
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。

链接: https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
"""

# 滑动窗口
class Solution:
    def findLength(self, A: List[int], B: List[int]) -> int:
        def maxLength(addA: int, addB: int, length: int) -> int:
            ret = k = 0
            for i in range(length):
                if A[addA + i] == B[addB + i]:
                    k += 1
                    ret = max(ret, k)
                else:
                    k = 0
            return ret
        
        n, m = len(A), len(B)
        ret = 0
        for i in range(n):
            length = min(m, n - i)
            ret = max(ret, maxLength(i, 0, length))
        for i in range(m):
            length = min(n, m - i)
            ret = max(ret, maxLength(0, i, length))
        return ret

# 动态规划, O(n2)
# class Solution:
#     def findLength(self, A: List[int], B: List[int]) -> int:
#         m, n = len(A), len(B)
#         dp = [[0] * n for _ in range(m)]
#         res = 0
#         for i in range(m):
#             for j in range(n):
#                 if A[i] == B[j]:
#                     dp[i][j] = dp[i - 1][j - 1] + 1 if i > 0 and j > 0 else 1
#                     res = max(res, dp[i][j])
#         return res


# class Solution:
#     def findLength(self, A: List[int], B: List[int]) -> int:
#         m, n = len(A), len(B)
#         dp = [[0] * (n + 1) for _ in range(m + 1)]
#         res = 0
#         for i in range(m - 1, -1, -1):
#             for j in range(n - 1, -1, -1):
#                 dp[i][j] = dp[i + 1][j + 1] + 1 if A[i] == B[j] else 0
#                 res = max(res, dp[i][j])
#         return res


# O(n2)
# class Solution:
#     def findLength(self, A: List[int], B: List[int]) -> int:
#         dp = [[0] * len(B) for _ in range(len(A))]
#         for i in range(len(A)):
#             for j in range(len(B)):
#                 if A[i] == B[j]:
#                     dp[i][j] = 1
#         res = 0
#         for i in range(len(A)):
#             for j in range(len(B)):
#                 if dp[i][j] == 1:
#                     tmp = 1
#                     a, b = i + 1, j + 1
#                     while a < len(A) and b < len(B) and dp[a][b] == 1:
#                         dp[a][b] = 0
#                         tmp += 1
#                         a += 1; b += 1
#                     res = max(res, tmp)
#         return res


# 暴力, O(n3)
# class Solution:
#     def findLength(self, A: List[int], B: List[int]) -> int:
#         if len(A) < len(B):
#             return self.findLength(B, A)
        
#         for i in range(len(B), 0, -1):
#             for j in range(len(B) + 1 - i):
#                 for k in range(len(A) + 1 - i):
#                     if B[j:j + i] == A[k:k + i]:
#                         return i
#         return 0
