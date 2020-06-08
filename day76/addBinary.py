"""
67. 二进制求和
给你两个二进制字符串，返回它们的和（用二进制表示）。
输入为 非空 字符串且只包含数字 1 和 0。

链接: https://leetcode-cn.com/problems/add-binary/
"""

# 二进制转十进制，相加后再转回二进制
# class Solution:
#     def addBinary(self, a, b) -> str:
#         return '{0:b}'.format(int(a, 2) + int(b, 2))


# 逐位相加
# class Solution:
#     def addBinary(self, a: str, b: str) -> str:
#         n = max(len(a), len(b))
#         a = a.zfill(n); b = b.zfill(n)
#         carry = 0
#         res = []
#         for i in range(n - 1, -1, -1):
#             cur = int(a[i]) + int(b[i]) + carry
#             carry = cur >> 1
#             res.append(str(cur % 2))
#         if carry == 1:
#             res.append("1")
#         return "".join(res[::-1])


# 位运算
class Solution:
    def addBinary(self, a, b) -> str:
        x, y = int(a, 2), int(b, 2)
        while y:
            x, y = x ^ y, (x & y) << 1
        return bin(x)[2:]
