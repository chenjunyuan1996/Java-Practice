# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# DFS
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root: return []
        self.res = []
        self._dfs(root, 0)
        return self.res
    
    def _dfs(self, node, level):
        if not node: return
        
        if len(self.res) < level + 1:
            self.res.append([])

        self.res[level].append(node.val)

        self._dfs(node.left, level + 1)
        self._dfs(node.right, level + 1)


# BFS
# class Solution:
#     def levelOrder(self, root: TreeNode) -> List[List[int]]:
#         if not root: return []

#         res = []
#         queue = collections.deque()
#         queue.append(root)
#         while queue:
#             cur_level = []
#             size = len(queue)

#             for _ in range(size):
#                 cur = queue.popleft()
#                 cur_level.append(cur.val)
#                 if cur.left: queue.append(cur.left)
#                 if cur.right: queue.append(cur.right)
                
#             res.append(cur_level)
#         return res
