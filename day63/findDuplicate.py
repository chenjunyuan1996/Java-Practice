"""
287. 寻找重复数
给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

说明：
不能更改原数组（假设数组是只读的）。
只能使用额外的 O(1) 的空间。
时间复杂度小于 O(n2) 。
数组中只有一个重复的数字，但它可能不止重复出现一次。

链接: https://leetcode-cn.com/problems/find-the-duplicate-number/
"""

# 哈希表: 时间复杂度O(n), 空间复杂度O(n)
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        dic = set()
        for num in nums:
            if num not in dic:
                dic.add(num)
            else:
                return num

# 二分法
# class Solution:
#     def findDuplicate(self, nums: List[int]) -> int:
#         left, right = 1, len(nums) - 1
#         while left <= right:
#             mid = left + ((right - left) >> 1)
#             count = 0
#             for num in nums:
#                 if num < mid:
#                     count += 1
#             if count < mid:
#                 left = mid + 1
#             else:
#                 right = mid - 1
#         return right
                
# 位图法
# class Solution:
#     def findDuplicate(self, nums: List[int]) -> int:
#         bit = (1 << len(nums)) - 1
#         for num in nums:
#             pivot = 1 << num
#             if bit & pivot == 0:
#                 return num
#             bit -= pivot

# 快慢指针: 当成环，求环的入口
# class Solution:
#     def findDuplicate(self, nums: List[int]) -> int:
#         slow, fast = nums[0], nums[nums[0]]
#         while slow != fast:
#             slow = nums[slow]
#             fast = nums[nums[fast]]
#         slow = 0
#         while slow != fast:
#             slow = nums[slow]
#             fast = nums[fast]
#         return slow

# 暴力法: 时间复杂度O(n^2), 空间复杂度O(1)
# class Solution:
#     def findDuplicate(self, nums: List[int]) -> int:
#         for i, pivot in enumerate(nums):
#             for num in nums[i + 1:]:
#                 if pivot == num:
#                     return num
