class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t): return False

        count = [0] * 26
        for i in range(len(s)):
            count[ord(s[i]) - ord('a')] += 1
            count[ord(t[i]) - ord('a')] -= 1
        return count == [0] * 26

# class Solution:
#     def isAnagram(self, s: str, t: str) -> bool:
#         dic1, dic2 = {}, {}
#         for item in s:
#             dic1[item] = dic1.get(item, 0) + 1
#         for item in t:
#             dic2[item] = dic2.get(item, 0) + 1
#         return dic1 == dic2

# class Solution:
#     def isAnagram(self, s: str, t: str) -> bool:
#         return sorted(s) == sorted(t)
