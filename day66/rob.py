class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums: return 0

        first, second = 0, nums[0]
        for i in range(1, len(nums)):
            first, second = second, max(first + nums[i], second)
        return second
        
# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         if len(nums) < 2: return max(nums + [0, 0])

#         day1 = 0
#         day2 = nums[0]
#         day3 = nums[1]
#         for i in range(2, len(nums)):
#             day1, day2, day3 = day2, day3, max(day1, day2) + nums[i]

#         return max(day2, day3)
