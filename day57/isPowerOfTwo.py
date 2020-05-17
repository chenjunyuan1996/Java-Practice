class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        return n > 0 and n & (n - 1) == 0

# class Solution:
#     def isPowerOfTwo(self, n: int) -> bool:
#         if n <= 0: return False
#         res = 0
#         while n != 0:
#             n &= n - 1
#             res += 1
#         return res == 1
