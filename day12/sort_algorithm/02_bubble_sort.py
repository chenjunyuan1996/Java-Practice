# 冒泡排序
# 临近两个数字比较

class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            for j in range(1, len(nums) - i):
                if nums[j] < nums[j - 1]:
                    nums[j], nums[j - 1] = nums[j - 1], nums[j]
        return nums
