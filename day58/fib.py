# 动态规划，自下而上，记录最新状态
class Solution:
    def fib(self, n: int) -> int:
        a, b = 0, 1
        for _ in range(n):
            a, b = b, a + b
        return a

# 动态规划，自下而上，记录全部数值
# class Solution:
#     def fib(self, n: int) -> int:
#         dp = [0, 1]
#         while len(dp) <= n:
#             dp.append(dp[-1] + dp[-2])
#         return dp[n]

# 递归，自上而下
# class Solution:
#     def fib(self, n: int) -> int:
#         if n <= 1: return n
#         return self.fib(n - 1) + self.fib(n - 2)
