# class Solution:
#     def longestValidParentheses(self, s: str) -> int:
#         res = 0
#         stack = [-1]
#         for i in range(len(s)):
#             if s[i] == "(":
#                 stack.append(i)
#             else:
#                 stack.pop()
#                 if not stack:
#                     stack.append(i)
#                 else:
#                     res = max(res, i - stack[-1])
#         return res


class Solution:
    def longestValidParentheses(self, s: str) -> int:
        res = 0
        dp = [0] * len(s)
        for i in range(1, len(s)):
            if s[i] == ")":
                if s[i - 1] == "(":
                    dp[i] = dp[i - 2] + 2 if i >= 2 else 2
                elif i > dp[i - 1] and s[i - dp[i - 1] - 1] == "(":
                    dp[i] = dp[i - 1] + (dp[i - dp[i - 1] - 2] + 2 if i - dp[i - 1] >= 2 else 2)
                res = max(res, dp[i])
        return res
