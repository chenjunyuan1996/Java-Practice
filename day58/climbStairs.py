# 动态规划
class Solution:
    def climbStairs(self, n: int) -> int:
        a = b = 1
        for _ in range(n):
            a, b = b, a + b
        return a

# 回朔 + 缓存
# class Solution:
#     def __init__(self):
#         self.dic = {0: 1, 1: 1}

#     def climbStairs(self, n: int) -> int:
#         if n < 2: return self.dic[n]
        
#         if n not in self.dic:
#             tmp = self.climbStairs(n - 1) + self.climbStairs(n - 2)
#             self.dic[n] = tmp
#         return self.dic[n]

# 递归
# class Solution:
#     def climbStairs(self, n: int) -> int:
#         if n < 2: return 1
#         return self.climbStairs(n - 1) + self.climbStairs(n - 2)
