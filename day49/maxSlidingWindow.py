class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res = []
        win = collections.deque()
        for i, num in enumerate(nums):
            if i >= k and win[0] <= i - k:
                win.popleft()
            while win and nums[win[-1]] <= num:
                win.pop()
            win.append(i)
            if i >= k - 1:
                res.append(nums[win[0]])
        return res
