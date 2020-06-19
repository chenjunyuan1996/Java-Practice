/*
125. 验证回文串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
说明：本题中，我们将空字符串定义为有效的回文串。

链接: https://leetcode-cn.com/problems/valid-palindrome/
*/

class Solution:
    def isPalindrome(self, s: str) -> bool:
        tmp = "".join([n.lower() for n in s if n.isalnum()])
        return tmp == tmp[::-1]


# 空间复杂度O(1))
# class Solution:
#     def isPalindrome(self, s: str) -> bool:
#         l, r = 0, len(s) - 1
#         while l < r:
#             while l < r and not s[l].isalnum():
#                 l += 1
#             while l < r and not s[r].isalnum():
#                 r -= 1
#             if s[l].lower() != s[r].lower():
#                 return False
#             l += 1; r -= 1
#         return True


# class Solution:
#     def isPalindrome(self, s: str) -> bool:
#         if not s: return True

#         tmp = [n.lower() for n in s if n.isalnum()]
#         size = len(tmp)
#         for i in range(size // 2):
#             if tmp[i] != tmp[size - 1 - i]:
#                 return False
#         return True
