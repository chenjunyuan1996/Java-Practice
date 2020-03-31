class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        n = len(nums)
        gap = n // 2
        while gap:
            for i in range(gap, n):
                while i - gap >= 0 and nums[i - gap] > nums[i]:
                    nums[i - gap], nums[i] = nums[i], nums[i - gap]
                    i -= gap
            gap //= 2
        return nums
