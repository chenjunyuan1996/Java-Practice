# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if not root: return 0
        self.max_value = 0
        self._dfs(root, 0)
        return self.max_value
        
    def _dfs(self, node, level):
        if not node: 
            self.max_value = max(self.max_value, level)
            return
        
        self._dfs(node.left, level + 1)
        self._dfs(node.right, level + 1)

# BFS
# class Solution:
#     def maxDepth(self, root: TreeNode) -> int:
#         if not root: return 0

#         queue = collections.deque()
#         queue.append(root)
#         res = 0
#         while queue:
#             size = len(queue)
#             res += 1
#             for _ in range(size):
#                 cur = queue.popleft()
#                 if cur.left: queue.append(cur.left)
#                 if cur.right: queue.append(cur.right)
#         return res

# recursion
# class Solution:
#     def maxDepth(self, root: TreeNode) -> int:
#         if not root: return 0
#         return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))
