# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 递归
# class Solution:
#     def convertBiNode(self, root: TreeNode) -> TreeNode:
#         res = TreeNode(0)
#         cur = res
#         def inOrder(cur, root):
#             if root == None: return cur
#             cur = inOrder(cur, root.left)
#             root.left = None
#             cur.right = root
#             cur = cur.right
#             cur = inOrder(cur, root.right)
#             return cur
#         cur = inOrder(cur, root)
#         return res.right

# 循环
class Solution:
    def convertBiNode(self, root: TreeNode) -> TreeNode:
        res = TreeNode(0)
        cur = res
        stack = collections.deque()
        while root or stack:
            if root:
                stack.append(root)
                root = root.left
            else:
                root = stack.pop()
                root.left = None
                cur.right = root
                cur = cur.right
                root = root.right
        return res.right
