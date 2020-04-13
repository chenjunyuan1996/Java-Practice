class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        def rankOrder(nums, n):
            if n == len(nums):
                res.append(nums[:])
                return
            for i in range(n, len(nums)):
                nums[i], nums[n] = nums[n], nums[i]
                rankOrder(nums, n + 1)
                nums[i], nums[n] = nums[n], nums[i]
            return
        rankOrder(nums, 0)
        return res

# class Solution:
#     def permute(self, nums: List[int]) -> List[List[int]]:
#         res = []
#         def rankOrder(nums, n):
#             if n == 1:
#                 res.append(nums[:])
#                 return
#             for i in range(n):
#                 nums[i], nums[n - 1] = nums[n - 1], nums[i]
#                 rankOrder(nums, n - 1)
#                 nums[i], nums[n - 1] = nums[n - 1], nums[i]
#             return
#         rankOrder(nums, len(nums))
#         return res
