'''
1、染色问题：
遍历所有节点；如果节点为1，count++，将节点和附近节点染色为0；BFS/DFS
2、并查集
'''

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def sink(i, j):
            if 0 <= i < len(grid) and 0 <= j < len(grid[i]) and grid[i][j] == '1':
                grid[i][j] = '0'
                sink(i+1, j); sink(i-1, j); sink(i, j+1); sink(i, j-1)
                # map(sink, (i+1, i-1, i, i), (j, j, j+1, j-1))
                return 1
            return 0
        return sum(sink(i, j) for i in range(len(grid)) for j in range(len(grid[i])))

# 并查集
# class UnionFind:
#     def __init__(self, grid):
#         m, n = len(grid), len(grid[0])
#         self.count = 0
#         self.parent = [-1] * (m * n)
#         self.rank = [0] * (m * n)
#         for i in range(m):
#             for j in range(n):
#                 if grid[i][j] == "1":
#                     self.parent[i * n + j] = i * n + j
#                     self.count += 1
    
#     def find(self, i):
#         if self.parent[i] != i:
#             self.parent[i] = self.find(self.parent[i])
#         return self.parent[i]
    
#     def Union(self, x, y):
#         rootx = self.find(x)
#         rooty = self.find(y)
#         if rootx != rooty:
#             if self.rank[rootx] > self.rank[rooty]:
#                 self.parent[rooty] = rootx
#             elif self.rank[rootx] < self.rank[rooty]:
#                 self.parent[rootx] = rooty
#             else:
#                 self.parent[rooty] = rootx
#                 self.rank[rootx] += 1
#             self.count -= 1

# class Solution:
#     def numIslands(self, grid: List[List[str]]) -> int:
#         if not grid or not grid[0]: return 0

#         uf = UnionFind(grid)
#         directions = [(0,-1), (0,1), (-1,0), (1,0)]
#         m ,n = len(grid), len(grid[0])

#         for i in range(m): 
#             for j in range(n):
#                 if grid[i][j] == '0': continue
#                 for di, dj in directions:
#                     nr, nc = i + di, j + dj
#                     if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == "1":
#                         uf.Union(i * n + j, nr * n + nc)
#         return uf.count


# DFS（递归） + 不改变地图
# class Solution:
#     def numIslands(self, grid: List[List[str]]) -> int:
#         self.dx = [-1, 1, 0, 0]
#         self.dy = [0, 0, -1, 1]

#         if not grid: return 0
#         self.max_x = len(grid); self.max_y = len(grid[0]); self.grid = grid
#         self.visited = set()
#         return sum([self.floodfill_DFS(i, j) for i in range(self.max_x) for j in range(self.max_y)])

#     def floodfill_DFS(self, x, y):
#         if not self._is_valid(x, y): return 0
#         self.visited.add((x, y))
#         for k in range(4):
#             self.floodfill_DFS(x + self.dx[k], y + self.dy[k])
#         return 1
    
#     def _is_valid(self, x, y):
#         if 0 <= x < self.max_x and 0 <= y < self.max_y and self.grid[x][y] == "1" and (x, y) not in self.visited:
#             return True
#         return False

# BFS + 不改变地图
# class Solution:
#     def numIslands(self, grid: List[List[str]]) -> int:
#         if not grid or not grid[0]: return 0

#         res = 0
#         max_x = len(grid); max_y = len(grid[0])
#         move = [[0, 1], [0, -1], [1, 0], [-1, 0]]
#         visited = set()
#         for i in range(max_x):
#             for j in range(max_y):
#                 if grid[i][j] == "1" and (i, j) not in visited:
#                     res += 1
#                     queue = collections.deque()
#                     queue.append((i, j))
#                     visited.add((i, j))
#                     while queue:
#                         m, n = queue.popleft()
#                         for dm, dn in move:
#                             new_m = m + dm; new_n = n + dn
#                             if 0 <= new_m < max_x and 0 <= new_n < max_y and grid[new_m][new_n] == "1" and (new_m, new_n) not in visited:
#                                 queue.append((new_m, new_n))
#                                 visited.add((new_m, new_n))
#         return res

# BFS + 改变地图
# class Solution:
#     def numIslands(self, grid: List[List[str]]) -> int:
#         res = 0
#         move = [[0, 1], [0, -1], [1, 0], [-1, 0]]
#         for i in range(len(grid)):
#             for j in range(len(grid[i])):
#                 if grid[i][j] == "1":
#                     res += 1
#                     queue = collections.deque()
#                     queue.append([i, j])
#                     grid[i][j] = "0"
#                     while queue:
#                         m, n = queue.popleft()
#                         for dm, dn in move:
#                             if 0 <= m + dm < len(grid) and 0 <= n + dn < len(grid[m]) and grid[m + dm][n + dn] == "1":
#                                 queue.append([m + dm, n + dn])
#                                 grid[m + dm][n + dn] = "0"
#         return res
