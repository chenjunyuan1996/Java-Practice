class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) < 2: return 0
        pmin = prices[0]
        pmax = 0
        for i in range(1, len(prices)):
            pmax = max(pmax, prices[i] - pmin)
            pmin = min(pmin, prices[i])
        return pmax
        
# class Solution:
#     def maxProfit(self, prices: List[int]) -> int:
#         if not prices: return 0
#         state = [[0] * 2 for _ in range(len(prices))]
#         state[0][1] = -prices[0]
#         for i in range(1, len(prices)):
#             state[i][0] = max(state[i - 1][0], state[i - 1][1] + prices[i])
#             state[i][1] = max(state[i - 1][1], -prices[i])
#         return state[-1][0]

# class Solution:
#     def maxProfit(self, prices: List[int]) -> int:
#         buy = int(1e9)
#         profit = 0
#         for price in prices:
#             if price < buy:
#                 buy = price
#             elif price - buy > profit:
#                 profit = price - buy
#         return profit
