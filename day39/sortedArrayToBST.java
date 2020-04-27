/*
最小高度树
给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return BST(nums, 0, nums.length);
    }

    public TreeNode BST(int[] nums, int start, int end) {
        if (start == end) return null;

        int mid = start + (end - start) / 2;
        TreeNode res = new TreeNode(nums[mid]);
        res.left = BST(nums, start, mid);
        res.right = BST(nums, mid + 1, end);
        return res;
    }

}
// class Solution {
//     public TreeNode sortedArrayToBST(int[] nums) {
//         if (nums.length == 0) return null;

//         int mid = nums.length / 2;
//         TreeNode res = new TreeNode(nums[mid]);
//         res.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
//         res.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
//         return res;
//     }
// }
