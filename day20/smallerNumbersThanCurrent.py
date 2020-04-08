class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        nmax = max(nums)
        nmin = min(nums)
        size = nmax - nmin + 1
        count = [0] * size
        for n in nums:
            count[n - nmin] += 1
        for i in range(1, size):
            count[i] += count[i - 1]
        res = []
        for n in nums:
            if n == nmin:
                res.append(0)
            else:
                res.append(count[n - nmin - 1])
        return res
