class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort();
        res = []
        for i in range(len(nums) - 3):
            if (i > 0 and nums[i] == nums[i - 1]): continue
            for j in range(i + 1, len(nums) - 2):
                if (j > i + 1 and nums[j] == nums[j - 1]): continue
                if (nums[i] + nums[j] + nums[-2] + nums[-1]) < target: continue
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target): break

                k, l = j + 1, len(nums) - 1
                while k < l:
                    the_sum = nums[i] + nums[j] + nums[k] + nums[l]
                    if the_sum > target: l -= 1
                    elif the_sum < target: k += 1
                    else:
                        res.append([nums[i], nums[j], nums[k], nums[l]])
                        l -= 1; k += 1
                        while k < l and nums[l] == nums[l + 1]: l -= 1
                        while k < l and nums[k] == nums[k - 1]: k += 1
        return res
