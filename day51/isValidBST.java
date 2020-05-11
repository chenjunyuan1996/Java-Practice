/*
98. 验证二叉搜索树
给定一个二叉树，判断其是否是一个有效的二叉搜索树。
假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/validate-binary-search-tree
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
    private TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }

    private boolean helper(TreeNode root) {
        if (root == null) return true;
        if (!helper(root.left)) return false;
        if (this.prev != null && this.prev.val >= root.val) return false;
        this.prev = root;
        return helper(root.right);
    }
}

// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return isValid(root, null, null);
//     }

//     public boolean isValid(TreeNode root, Integer min, Integer max) {
//         if (root == null) return true;
//         if (min != null && root.val <= min) return false;
//         if (max != null && root.val >= max) return false;
//         return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
//     }
// }
