class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        num_set = set(nums)
        res = 0
        for num in nums:
            if num - 1 in num_set:
                continue
            cur = num + 1; tmp = 1
            while cur in num_set:
                cur += 1
                tmp += 1
            res = max(res, tmp)
        return res
