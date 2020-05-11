# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self.helper(root, None, None)

    def helper(self, root, val_min, val_max):
        if root is None: return True
        if val_min != None and val_min >= root.val: return False
        if val_max != None and val_max <= root.val: return False
        return self.helper(root.left, val_min, root.val) and self.helper(root.right, root.val, val_max)


# class Solution:
#     def isValidBST(self, root: TreeNode) -> bool:
#         self.prev = None
#         return self.helper(root)
        
#     def helper(self, root):
#         if root is None: return True
#         # 左
#         if not self.helper(root.left): return False
#         # 中
#         if self.prev and self.prev.val >= root.val: return False
#         self.prev = root
#         # 右
#         return self.helper(root.right)

# class Solution:
#     def isValidBST(self, root: TreeNode) -> bool:
#         inorder = self.inorder(root)
#         return inorder == list(sorted(set(inorder)))
        
#     def inorder(self, root):
#         if root is None: return []
#         return self.inorder(root.left) + [root.val] + self.inorder(root.right)
