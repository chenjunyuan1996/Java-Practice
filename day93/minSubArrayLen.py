# 双指针法，O(n)
class Solution:
    def minSubArrayLen(self, s: int, nums: List[int]) -> int:
        if not nums:
            return 0
        
        n = len(nums)
        l, r = 0, 0
        res = n + 1
        total = 0
        while r < n:
            total += nums[r]
            while total >= s:
                res = min(res, r - l + 1)
                total -= nums[l]
                l += 1
            r += 1
        return 0 if res == n + 1 else res


# 暴力法
# class Solution:
#     def minSubArrayLen(self, s: int, nums: List[int]) -> int:
#         if not nums or sum(nums) < s:
#             return 0
#         for i in range(1, len(nums) + 1):
#             for j in range(len(nums) + 1 - i):
#                 if sum(nums[j : j + i]) >= s:
#                     return i


# class Solution:
#     def minSubArrayLen(self, s: int, nums: List[int]) -> int:
#         if not nums:
#             return 0 
#         n = len(nums)
#         ans = n + 1
#         for i in range(n):
#             total = 0
#             for j in range(i, n):
#                 total += nums[j]
#                 if total >= s:
#                     ans = min(ans, j - i + 1)
#                     break
#         return 0 if ans == n + 1 else ans
