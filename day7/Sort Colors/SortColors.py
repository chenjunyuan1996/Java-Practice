class Solution:
    def sortColors(self, nums: List[int]) -> None:
        left = cur = 0
        right = len(nums) - 1
        while cur <= right:
            if nums[cur] == 0:
                nums[cur], nums[left] = nums[left], nums[cur]
                left += 1
                cur += 1
            elif nums[cur] == 1:
                cur += 1
            elif nums[cur] == 2:
                nums[cur], nums[right] = nums[right], nums[cur]
                right -= 1
        return
