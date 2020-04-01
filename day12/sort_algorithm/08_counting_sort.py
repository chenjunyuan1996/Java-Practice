class Solution:
    def counting_sort(self, nums):
        if nums:
            nmax = max(nums) + 1
            nmin = min(nums)

            counting_arr = [0] * (nmax - nmin)
            for num in nums:
                counting_arr[num - nmin] += 1
            
            pivot = 0
            for i in range(len(counting_arr)):
                for j in range(counting_arr[i]):
                    nums[pivot] = nmin + i
                    pivot += 1
        return nums

    def sortArray(self, nums: List[int]) -> List[int]:
        return self.counting_sort(nums)
