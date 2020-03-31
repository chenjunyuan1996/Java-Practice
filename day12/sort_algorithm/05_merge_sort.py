# 归并排序

class Solution:
    def merge(left, right):
        res = []
        i = j = 0
        while i < len(left) and j < len(right):
            if left[i] <= right[j]:
                res.append(left[i])
                i += 1
            else:
                res.append(right[j])
                j += 1
        res += left[i:] + right[j:]
        return res

    def merge_sort(self, nums):
        if len(nums) < 2: return nums
        mid = len(nums) // 2
        # 分
        left = self.merge_sort(nums[:mid])
        right = self.merge_sort(nums[mid:])
        # 并
        return merge(left,right)

    def sortArray(self, nums: List[int]) -> List[int]:
        nums = self.merge_sort(nums)
        return nums
