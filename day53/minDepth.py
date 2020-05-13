# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# recursion
class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root: return 0
        
        if not root.left: return 1 + self.minDepth(root.right)
        if not root.right: return 1 + self.minDepth(root.left)
        
        return 1 + min(self.minDepth(root.left), self.minDepth(root.right))

# class Solution:
#     def minDepth(self, root: TreeNode) -> int:
#         if not root: return 0
#         left = self.minDepth(root.left)
#         right = self.minDepth(root.right)
#         return 1 + left + right if left * right == 0 else 1 + min(left, right)

# BFS
# class Solution:
#     def minDepth(self, root: TreeNode) -> int:
#         if not root: return 0

#         res = 0
#         queue = collections.deque()
#         queue.append(root)

#         while queue:
#             res += 1
#             size = len(queue)
#             for _ in range(size):
#                 cur = queue.popleft()
#                 if not cur.left and not cur.right: return res
#                 if cur.left: queue.append(cur.left)
#                 if cur.right: queue.append(cur.right)
