"""
面试题46. 把数字翻译成字符串
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

链接: https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
"""

# 不转成字符串
class Solution:
    def translateNum(self, num: int) -> int:
        a, b = 1, 1
        while num // 10 != 0:
            a, b = b, a + b if 10 <= num - num // 100 * 100 <= 25 else b
            num //= 10
        return b


# 转换成字符串
# class Solution:
#     def translateNum(self, num: int) -> int:
#         num = str(num)
#         a, b = 1, 1
#         for i in range(1, len(num)):
#             a, b = b, a + b if "10" <= num[i-1:i+1] <= "25" else b
#         return b
