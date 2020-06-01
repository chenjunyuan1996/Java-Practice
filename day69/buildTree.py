# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# class Solution:
#     def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
#         if not preorder: return None

#         root = TreeNode(preorder[0])
#         index = inorder.index(root.val)
#         root.left = self.buildTree(preorder[1: index + 1], inorder[:index])
#         root.right = self.buildTree(preorder[index + 1:], inorder[index + 1:])
#         return root


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder: return None

        def recursion(l, r, f, e):
            if l == r or f == e: return None

            root = TreeNode(preorder[l])
            index = inorder.index(root.val) - f
            root.left = recursion(l + 1, l + index + 1, f, f + index)
            root.right = recursion(l + index + 1, r, f + index + 1, e)
            return root
        
        return recursion(0, len(preorder), 0, len(inorder))
