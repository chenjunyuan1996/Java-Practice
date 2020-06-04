class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        size = len(nums)
        res = [1] * size
        l = r = 1
        for i in range(1, size):
            l *= nums[i - 1]
            r *= nums[size - i]
            res[i] *= l
            res[size - 1 - i] *= r

        return res

# class Solution:
#     def productExceptSelf(self, nums: List[int]) -> List[int]:
#         size = len(nums)
#         left, right, res = [1] * size, [1] * size, [1] * size
        
#         for i in range(1, size):
#             left[i] = left[i - 1] * nums[i - 1]
#             right[size - i - 1] = right[size - i] * nums[size - i]
        
#         for i in range(len(nums)):
#             res[i] = left[i] * right[i]
#         return res
