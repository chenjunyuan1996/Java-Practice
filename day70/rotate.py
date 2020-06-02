class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        size = len(nums)
        k %= size
        if k != 0:
            count = self.fun(size, k)
            for i in range(count):
                cur = i
                pre = nums[i]
                while True:
                    aft = (cur + k) % size
                    nums[aft], pre, cur = pre, nums[aft], aft
                    if i == cur:
                        break

    def fun(self, a, b):
        while a % b != 0:
            a, b = b, a % b
        return b


# class Solution:
#     def rotate(self, nums: List[int], k: int) -> None:
#         """
#         Do not return anything, modify nums in-place instead.
#         """
#         size = len(nums)
#         k %= size
#         count = start = 0

#         while count < size:
#             cur = start
#             pre = nums[start]
#             while True:
#                 aft = (cur + k) % size
#                 nums[aft], pre, cur = pre, nums[aft], aft
#                 count += 1
#                 if start == cur:
#                     break
#             start += 1


# class Solution:
#     def rotate(self, nums: List[int], k: int) -> None:
#         """
#         Do not return anything, modify nums in-place instead.
#         """
#         while k > 0:
#             nums.insert(0, nums.pop())
#             k -= 1
