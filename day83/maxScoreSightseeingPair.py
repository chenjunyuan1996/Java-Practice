class Solution:
    def maxScoreSightseeingPair(self, A: List[int]) -> int:
        res = 0
        mx = A[0] + 0
        for i in range(1, len(A)):
            res = max(res, A[i] - i + mx)
            mx = max(mx, A[i] + i)
        return res


# 暴力循环
# class Solution:
#     def maxScoreSightseeingPair(self, A: List[int]) -> int:
#         res = 0
#         for i in range(len(A) - 1):
#             for j in range(i + 1, len(A)):
#                 res = max(res, A[i] + A[j] + i - j)
#         return res
