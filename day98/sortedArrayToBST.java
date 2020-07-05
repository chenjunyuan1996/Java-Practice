/*
108. 将有序数组转换为二叉搜索树
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

链接: https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
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
    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;

        this.nums = nums;
        return helper(0, nums.length);
    }

    private TreeNode helper(int l, int r) {
        if (l == r) return null;

        int index = l + (r - l) / 2;
        TreeNode root = new TreeNode(this.nums[index]);
        root.left = helper(l, index);
        root.right = helper(index+1, r);
        return root;
    }
}
