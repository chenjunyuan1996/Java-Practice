class Solution:
    def findRepeatNumber(self, nums: List[int]) -> int:
        dic = set()
        for num in nums:
            if num in dic:
                return num
            dic.add(num)
        return -1

# class Solution:
#     def findRepeatNumber(self, nums: List[int]) -> int:
#         for i, target in enumerate(nums):
#             for num in nums[i + 1:]:
#                 if target == num:
#                     return target
#         return -1

# class Solution:
#     def findRepeatNumber(self, nums: List[int]) -> int:
#         nums.sort()
#         for i in range(len(nums) - 1):
#             if nums[i] == nums[i + 1]:
#                 return nums[i]
#         return -1
