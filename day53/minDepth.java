/*
111. 二叉树的最小深度
给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明: 叶子节点是指没有子节点的节点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return left * right == 0 ? 1 + left + right : 1 + Math.min(left, right);
    }
}

// class Solution {
//     public int minDepth(TreeNode root) {
//         if (root == null) return 0;

//         if (root.left == null) return 1 + minDepth(root.right);
//         if (root.right == null) return 1 + minDepth(root.left);

//         return 1 + Math.min(minDepth(root.left), minDepth(root.right));

//     }
// }
