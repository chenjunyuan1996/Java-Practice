'''
63. 不同路径 II
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

链接: https://leetcode-cn.com/problems/unique-paths-ii/
'''

# 动态规划
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        res = [0] * (n + 1)
        res[1] = 1 if obstacleGrid[0][0] == 0 else 1
        for i in range(m):
            for j in range(n):
                if obstacleGrid[i][j] == 1:
                    res[j + 1] = 0
                    continue
                res[j + 1] += res[j]
        return res[-1]


# class Solution:
#     def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
#         m, n = len(obstacleGrid), len(obstacleGrid[0])
#         if obstacleGrid[0][0]:
#             return 0

#         obstacleGrid[0][0] = 1
#         for i in range(1, m):
#             if not obstacleGrid[i][0]:
#                 obstacleGrid[i][0] = 1
#             else:
#                 for k in range(i, m):
#                     obstacleGrid[k][0] = 0
#                 break
 
#         for j in range(1, n):
#             if not obstacleGrid[0][j]: 
#                 obstacleGrid[0][j] = 1
#             else:
#                 for l in range(j, n):
#                     obstacleGrid[0][l] = 0
#                 break
        
#         for i in range(1, m):
#             for j in range(1, n):
#                 if obstacleGrid[i][j]:
#                     obstacleGrid[i][j] = 0
#                 else:
#                     obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]
#         return obstacleGrid[m - 1][n - 1]


# 回溯
# class Solution:
#     def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
#         m, n = len(obstacleGrid), len(obstacleGrid[0])
#         self.res = 0

#         def helper(i, j):
#             if i == m or j == n or obstacleGrid[i][j]:
#                 return
#             if i == m - 1 and j == n - 1:
#                self.res += 1
#                return

#             helper(i + 1, j)
#             helper(i, j + 1)

#         helper(0, 0)
#         return self.res
