class Solution:
    def quick(self, nums, l, r):
        if l >= r:
            return nums
        first = l
        end = r
        while l < r:
            while l < r and nums[r] > nums[first]:
                r -= 1
            while l < r and nums[l] <= nums[first]:
                l += 1
            
            nums[l], nums[r] = nums[r], nums[l]
        nums[l], nums[first] = nums[first], nums[l]
        self.quick(nums, first, l - 1)
        self.quick(nums, l + 1, end)
        return nums

    def sortArray(self, nums: List[int]) -> List[int]:
        return self.quick(nums, 0, len(nums) - 1)
