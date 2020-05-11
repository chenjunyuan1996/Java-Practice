# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# class Solution:
#     def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
#         if root == None or root == p or root == q: return root
#         if self.lowestCommonAncestor(root.left, p, q) == None: return 
#         self.lowestCommonAncestor(root.right, p, q)

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if (p.val - root.val) * (q.val - root.val) <= 0: return root
        return self.lowestCommonAncestor(root.left, p, q) if q.val < root.val else self.lowestCommonAncestor(root.right, p ,q)
