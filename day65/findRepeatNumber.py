# class Solution:
#     def findRepeatNumber(self, nums: List[int]) -> int:
#         for i, num in enumerate(nums):
#             while num != i:
#                 if num == nums[num]:
#                     return num
#                 nums[i], nums[num] = nums[num], nums[i]

# 重排数组，把数组数字和下标对应上
class Solution:
    def findRepeatNumber(self, nums: List[int]) -> int:
        for i, num in enumerate(nums):
            if num == i: continue
            if nums[num] == num:
                return num
            nums[num], nums[i] = nums[i], nums[num]

# 采用哈希表，增加了空间复杂度
# class Solution:
#     def findRepeatNumber(self, nums: List[int]) -> int:
#         dic = set()
#         for num in nums:
#             if num in dic:
#                 return num
#             dic.add(num)
#         return -1

# 暴力搜索
# class Solution:
#     def findRepeatNumber(self, nums: List[int]) -> int:
#         for i, target in enumerate(nums):
#             for num in nums[i + 1:]:
#                 if target == num:
#                     return target
#         return -1

# 从小到大排序数组，寻找相邻两个相似的值
# class Solution:
#     def findRepeatNumber(self, nums: List[int]) -> int:
#         nums.sort()
#         for i in range(len(nums) - 1):
#             if nums[i] == nums[i + 1]:
#                 return nums[i]
#         return -1
