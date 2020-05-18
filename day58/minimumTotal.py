class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        dp = triangle[-1]
        for i in range(len(triangle) - 1, 0, -1):
            for j in range(i):
                dp[j] = min(dp[j], dp[j + 1]) + triangle[i - 1][j]
        return dp[0]
