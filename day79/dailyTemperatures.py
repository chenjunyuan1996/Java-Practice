/*
739. 每日温度
根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。

链接: https://leetcode-cn.com/problems/daily-temperatures/
*/

# 单调栈
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        res = [0] * len(T)
        stack = []
        for i in range(len(T)):
            temp = T[i]
            while stack and temp > T[stack[-1]]:
                index = stack.pop()
                res[index] = i - index
            stack.append(i)
        return res


# 原始、朴素、笨拙的写法，暴力求解并针对各种特殊情况进行剪枝
# class Solution:
#     def dailyTemperatures(self, T: List[int]) -> List[int]:
#         res = []
#         TT = max(T)
#         for i in range(len(T)):
#             if T[i] == TT:
#                 res += [0]
#                 continue            
#             if i > 0 and T[i] == T[i - 1]:
#                 if res[-1] == 0:
#                     res += [0]
#                 else:
#                     res += [res[-1] - 1]
#                 continue
#             j = i + 1
#             while j < len(T) and T[j] <= T[i]:
#                 j += 1
#             res += [0] if j == len(T) else [j - i]
#         return res


# 纯暴力，用哈希表来提高速度
# class Solution:
#     def dailyTemperatures(self, T: List[int]) -> List[int]:
#         n = len(T)
#         ans, nxt, big = [0] * n, dict(), 10**9
#         for i in range(n - 1, -1, -1):
#             warmer_index = min(nxt.get(t, big) for t in range(T[i] + 1, 102))
#             if warmer_index != big:
#                 ans[i] = warmer_index - i
#             nxt[T[i]] = i
#         return ans
