/*
15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。
https://leetcode-cn.com/problems/3sum/
 */

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        if len(nums) < 3: return []
        nums.sort()
        res = set()
        for i, v in enumerate(nums[:-2]):
            if i >= 1 and v == nums[i - 1] or v > 0: continue
            d = set()
            for x in nums[i + 1:]:
                if x not in d:
                    d.add(-v-x)
                else:
                    res.add((v, -v-x, x))
        
        return list(map(list, res))

# class Solution:
#     def threeSum(self, nums: List[int]) -> List[List[int]]:
#         res = []
#         nums.sort()
#         for i in range(len(nums) - 2):
#             if i > 0 and nums[i] == nums[i - 1] or nums[i] > 0: continue
#             j, k = i + 1, len(nums) - 1
#             while j < k:
#                 three_sum = nums[i] + nums[j] + nums[k]
#                 if three_sum > 0:
#                     k -= 1
#                 elif three_sum < 0:
#                     j += 1
#                 elif three_sum == 0:
#                     res.append([nums[i], nums[j], nums[k]])
#                     k -= 1
#                     j += 1
#                     while nums[k] == nums[k + 1] and j < k: k -= 1
#                     while nums[j] == nums[j - 1] and j < k: j += 1
#         return res
