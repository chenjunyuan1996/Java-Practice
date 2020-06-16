# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if root == None: return "X,"
        return str(root.val) + "," + self.serialize(root.left) + self.serialize(root.right)
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        def bulidTree(tree_list):
            val = next(tree_list)
            if val == "X": return None

            root = TreeNode(int(val))
            root.left = bulidTree(tree_list)
            root.right = bulidTree(tree_list)
            return root
        tree_list = iter(data.split(","))
        return bulidTree(tree_list)
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
