# set O(n)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        for index, num in enumerate(nums):
            if target - num in hashmap:
                return [hashmap[target - num], index]
            hashmap[num] = index

# set O(2 * n)
# class Solution:
#     def twoSum(self, nums: List[int], target: int) -> List[int]:
#         hashmap = {}
#         for i, num in enumerate(nums):
#             hashmap[num] = i
#         for i, num in enumerate(nums):
#             if target - num in hashmap and hashmap[target - num] != i:
#                 return [i, hashmap[target - num]]


# 暴力法 O(n^2)
# class Solution:
#     def twoSum(self, nums: List[int], target: int) -> List[int]:
#         for i in range(len(nums) - 1):
#             for j in range(i + 1, len(nums)):
#                 if nums[i] + nums[j] == target:
#                     return [i, j]
