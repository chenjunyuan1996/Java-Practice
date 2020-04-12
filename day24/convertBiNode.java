/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 循环
class Solution {
    
    public TreeNode convertBiNode(TreeNode root) {
        TreeNode res = new TreeNode(0);
        TreeNode cur = res;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root.left = null;
                cur.right = root;
                cur = cur.right;
                root = root.right;
            }
        }
        return res.right;
    }

}

// 递归
// class Solution {
    
//     public TreeNode convertBiNode(TreeNode root) {
//         TreeNode res = new TreeNode(0);
//         inOrder(root, res);
//         return res.right;
//     }

//     public TreeNode inOrder(TreeNode root, TreeNode cur) {
//         if (root == null) return cur;
//         cur = inOrder(root.left, cur);
//         root.left = null;
//         cur.right = root;
//         cur = cur.right;
//         cur = inOrder(root.right, cur);
//         return cur;
//     }

// }
