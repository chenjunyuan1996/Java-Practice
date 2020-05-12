# 分治法
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        def conquer(left, right):
            if left == right - 1: return nums[left]

            mid = (right - left) // 2 + left
            win_left = conquer(left, mid)
            win_right = conquer(mid, right)
            if win_left == win_right: return win_left

            left_count = sum(1 for num in nums[left:right] if num == win_left)
            right_count = sum(1 for num in nums[left:right] if num == win_right)
            return win_left if left_count > right_count else win_right

        return conquer(0, len(nums))

# 摩尔法
# class Solution:
#     def majorityElement(self, nums: List[int]) -> int:
#         count = 0
#         res = None
#         for num in nums:
#             if count == 0: res = num
#             count += 1 if res == num else -1
#         return res

# 哈希映射法
# class Solution:
#     def majorityElement(self, nums: List[int]) -> int:
#         counts = collections.Counter(nums)
#         return max(counts.keys(), key=counts.get)

# class Solution:
#     def majorityElement(self, nums: List[int]) -> int:
#         dic = dict()
#         for num in nums:
#             dic[num] = dic.get(num, 0) + 1
#         return max(dic, key=lambda x: dic[x])

# 排序法
# class Solution:
#     def majorityElement(self, nums: List[int]) -> int:
#         nums.sort()
#         return nums[len(nums) // 2]
