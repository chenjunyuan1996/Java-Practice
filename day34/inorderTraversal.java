// 给定一个二叉树，返回它的中序遍历。

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 非递归
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode cur = stack.pop();
                res.add(cur.val);
                root = cur.right;
            }
        }
        return res;
    }
}

// 递归
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         dfs(root, res);
//         return res;
//     }

//     private void dfs(TreeNode root, List<Integer> res) {
//         if (root == null) return;
//         dfs(root.left, res);
//         res.add(root.val);
//         dfs(root.right, res);
//         return;
//     }
// }
