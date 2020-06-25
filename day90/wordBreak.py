class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        hashset = set(wordDict)
        dp = [False] * (len(s) + 1)
        dp[0] = True
        for i in range(1, len(s) + 1):
            for j in range(i):
                if dp[j] and s[j:i] in hashset:
                    dp[i] = True
                    break
        return dp[-1]


# class Solution:
#     def wordBreak(self, s: str, wordDict: List[str]) -> bool:
#         hashset = set(wordDict)
#         def backtrack(s):
#             if s in hashset: 
#                 return True

#             for i in range(len(s) - 1):
#                 if s[:i + 1] in hashset and backtrack(s[i + 1:]):
#                     return True
#             return False
#         return backtrack(s)
