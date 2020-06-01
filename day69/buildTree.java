/*
面试题07. 重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

链接: https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
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

    private int[] preorder;
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            this.map.put(inorder[i], i);
        }

        return recursion(0, preorder.length, 0, inorder.length);

    }

    public TreeNode recursion(int l ,int r, int f, int e) {
        if (l == r || f == e) return null;

        TreeNode root = new TreeNode(this.preorder[l]);
        int i = this.map.get(this.preorder[l]) - f;
        root.left = recursion(l + 1, l + 1 + i, f, f + i);
        root.right = recursion(l + 1 + i, r, f + 1 + i, e);

        return root;
    }
}

