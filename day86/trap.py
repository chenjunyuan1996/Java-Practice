/*
42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

链接: https://leetcode-cn.com/problems/trapping-rain-water/
*/

# 暴力解法
# class Solution:
#     def trap(self, height: List[int]) -> int:
#         res = 0
#         for index, num in enumerate(height):
#             l = max(height[:index] + [num])
#             r = max(height[index + 1:] + [num])
#             res += min(l, r) - num
#         return res


# 动态规划
# class Solution:
#     def trap(self, height: List[int]) -> int:
#         if not height: return 0

#         l = [0] * len(height)
#         r = [0] * len(height)
#         l[0] = height[0]
#         r[-1] = height[-1]
#         for i in range(1, len(height) - 1):
#             l[i] = max(height[i], l[i - 1])
#         for i in range(len(height) - 2, 0, -1):
#             r[i] = max(height[i], r[i + 1])
#         res = 0
#         for i in range(1, len(height) - 1):
#             res += min(l[i], r[i]) - height[i]
#         return res


# 双指针
# class Solution:
#     def trap(self, height: List[int]) -> int:
#         res = 0
#         max_left, max_right = 0, 0
#         l, r = 1, len(height) - 2
#         while l <= r:
#             if height[l - 1] < height[r + 1]:
#                 max_left = max(max_left, height[l - 1])
#                 if max_left > height[l]:
#                     res += max_left - height[l]
#                 l += 1
#             else: 
#                 max_right = max(max_right, height[r + 1])
#                 if max_right > height[r]:
#                     res += max_right - height[r]
#                 r -= 1
#         return res


# 单调栈
class Solution:
    def trap(self, height: List[int]) -> int:
        res, cur = 0, 0
        stack = []
        while cur < len(height):
            while (stack and height[cur] > height[stack[-1]]):
                h = height[stack.pop()]
                # 排除首列
                if not stack:
                    break

                distance = cur - stack[-1] - 1
                length = min(height[stack[-1]], height[cur]) - h
                res += distance * length
            stack.append(cur)
            cur += 1
        return res
