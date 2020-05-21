# class Solution:
#     def lengthOfLIS(self, nums: List[int]) -> int:
#         LIS = []
#         for num in nums:
#             if not LIS or num > LIS[-1]:
#                 LIS.append(num)
#             else:
#                 left, right = 0, len(LIS) - 1
#                 while left <= right:
#                     mid = left + (right - left) // 2
#                     if LIS[mid] >= num:
#                         right = mid - 1
#                     else:
#                         left = mid + 1
#                 LIS[left] = num
#         return len(LIS)
            

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums: return 0

        res = 0
        dp = [1] * len(nums)
        for i in range(len(nums)):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
            res = max(res, dp[i])
        return res
