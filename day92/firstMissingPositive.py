# 分析: 时间复杂度为O(n)。所以不能对原数组进行排序；空间复杂度是O(1) 

# 哈希表: 时间复杂度O(n), 空间复杂度O(n)
# class Solution:
#     def firstMissingPositive(self, nums: List[int]) -> int:
#         dic = set(nums)
#         res = 1
#         while res in dic:
#             res += 1
#         return res

#  用列表模拟哈希表
class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        n = len(nums)
        for i in range(n):
            while 1 <= nums[i] <= n and nums[i] != nums[nums[i] - 1]:
                nums[nums[i] - 1], nums[i] = nums[i], nums[nums[i] - 1]

        for i in range(n):
            if i + 1 != nums[i]:
                return i + 1
        return n + 1
