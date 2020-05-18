# DP: 状态；状态转移方程
class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if not nums: return 0

        dp = [[0] * 2 for _ in range(len(nums))] 
        res = dp[0][0] = dp[0][1] = nums[0]
        for i in range(1, len(nums)):
            dp[i][0] = max(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i], nums[i])
            dp[i][1] = min(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i], nums[i])
            res = max(dp[i][0], res)

        return res


# class Solution:
#     def maxProduct(self, nums: List[int]) -> int:
#         # 处理特殊情况
#         if not nums: return 0
#         res = curMax = curMin = nums[0]
#         for i in range(1, len(nums)):
#             curMax, curMin = max(curMax * nums[i], curMin * nums[i], nums[i]), min(curMax * nums[i], curMin * nums[i], nums[i])
#             res = max(res, curMax)
#         return res


# 暴力递归
# class Solution:
#     def maxProduct(self, nums: List[int]) -> int:
#         self.res = nums[0]
#         self.backtrack(nums, 0, nums[0])
#         return self.res

#     def backtrack(self, nums, i, value):
#         if i == len(nums) - 1: 
#             self.res = max(self.res, value)
#             return

#         self.res = max(self.res, value)
#         self.backtrack(nums, i + 1, nums[i + 1])
#         self.backtrack(nums, i + 1, nums[i + 1] * value)
       

# 暴力循环
# class Solution:
#     def maxProduct(self, nums: List[int]) -> int:
#         res = nums[0]
#         for i in range(len(nums)):
#             temp = nums[i]
#             res = max(temp, res)
#             for j in range(i + 1, len(nums)):
#                 temp *= nums[j]
#                 res = max(temp, res)
#         return res
