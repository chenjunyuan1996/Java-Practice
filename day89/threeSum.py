# 暴力
class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        res = int(1e8)
        for i in range(len(nums) - 2):
            # 剪枝
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            
            l, r = i + 1, len(nums) - 1
            while l < r:
                n = nums[i] + nums[l] + nums[r]
    
                if n == target:
                    return n
                elif n < target:
                    l += 1
                elif n > target:
                    r -= 1
                #  更新res
                if abs(n - target) < abs(res - target):
                    res = n

        return res
