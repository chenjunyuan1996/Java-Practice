class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        for i in range(1, len(prices)):
            if prices[i] - prices[i - 1] > 0:
                profit += prices[i] - prices[i - 1]
        return profit

# class Solution:
#     def maxProfit(self, prices: List[int]) -> int:
#         dp_0 = 0
#         dp_1 = -int(1e9)
#         for price in prices:
#             temp = dp_0
#             dp_0 = max(dp_0, dp_1 + price)
#             dp_1 = max(dp_1, temp - price)
#         return dp_0

# class Solution:
#     def maxProfit(self, prices: List[int]) -> int:
#         # dp[0][0] = 0
#         # dp[0][1] = -prices[0]
#         # dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
#         # dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
        
#         if len(prices) < 2: return 0

#         dp = [[0] * 2 for _ in range(len(prices))]
#         dp[0][1] = -prices[0]
#         for i in range(1, len(prices)):
#             dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
#             dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
#         return dp[i][0]
