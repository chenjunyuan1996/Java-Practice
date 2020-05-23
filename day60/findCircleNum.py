# DFS
# class Solution:
#     def findCircleNum(self, M: List[List[int]]) -> int:
#         res = 0
#         for i in range(len(M)):
#             if M[i][i] == 1: 
#                 M[i][i] = 0
#                 res += 1
#                 M = self.dfs(M, i)
#         return res
    
#     def dfs(self, M, i):
#         for j in range(len(M[i])):
#             if M[i][j] == 1:
#                 M[i][j] = M[j][i] = M[j][j] = 0
#                 M = self.dfs(M, j)
#         return M


# BFS
class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        res = 0
        for i in range(len(M)):
            if M[i][i] == 1: 
                M[i][i] = 0
                res += 1

                queue = collections.deque()
                queue.append(i)
                while queue:
                    m = queue.popleft()
                    for n in range(len(M[m])):
                        if M[m][n] == 1:
                            M[m][n] = M[n][m] = M[n][n] = 0
                            queue.append(n)
        return res

# class Solution:
#     def findCircleNum(self, M: List[List[int]]) -> int:
#         res = 0
#         for i in range(len(M)):
#             if M[i][i] == 1: 
#                 M[i][i] = 0
#                 res += 1

#                 queue = collections.deque()
#                 for j in range(i + 1, len(M[i])):
#                     if M[i][j] == 1:
#                         queue.append(j)
#                         M[i][j] = M[j][i] = M[j][j] = 0
#                         while queue:
#                             m = queue.popleft()
#                             for n in range(len(M[m])):
#                                 if M[m][n] == 1:
#                                     M[m][n] = M[n][m] = M[n][n] = 0
#                                     queue.append(n)
#         return res
