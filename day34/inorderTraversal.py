# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        stack = []
        
        while stack or root:
            if root:
                stack.append(root)
                root = root.left
            else:
                cur = stack.pop()
                res.append(cur.val)
                root = cur.right
        return res

# class Solution:
#     def inorderTraversal(self, root: TreeNode) -> List[int]:
#         if not root: return []
#         stack = [(True, root)]
#         res = []

#         while stack:
#             flag, cur = stack.pop()
#             if flag:
#                 if cur.right: stack.append((True, cur.right))
#                 stack.append((False, cur))
#                 if cur.left: stack.append((True, cur.left))
#             else:
#                 res.append(cur.val)
#         return res

# class Solution:
#     def inorderTraversal(self, root: TreeNode) -> List[int]:
#         res = []
#         def dfs(root, res):
#             if not root: return
#             dfs(root.left, res)
#             res.append(root.val)
#             dfs(root.right, res)
#             return
#         dfs(root, res)
#         return res
