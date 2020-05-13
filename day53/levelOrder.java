/*
102. 二叉树的层序遍历
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
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

// DFS
class Solution {
    public List<List<Integer>> res;

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) new LinkedList<Integer>();
        
        this.res = new LinkedList<>();
        dfs(root, 0);
        return this.res;

    }

    public void dfs(TreeNode node, int level) {
        if (node == null) return;

        if (this.res.size() < level + 1) this.res.add(new LinkedList<Integer>());

        this.res.get(level).add(node.val);

        if (node.left != null) dfs(node.left, level + 1);
        if (node.right != null) dfs(node.right, level + 1);       
    }
}


// BFS
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         if (root == null) return new LinkedList<>();

//         Queue<TreeNode> queue = new LinkedList<>();
//         List<List<Integer>> res = new LinkedList<>();
//         queue.offer(root);

//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             List<Integer> curLevel = new LinkedList<>();

//             for (int i = 0; i < size; i++) {
//                 TreeNode node = queue.poll();
//                 curLevel.add(node.val);
//                 if (node.left != null) queue.offer(node.left);
//                 if (node.right != null) queue.offer(node.right);
//             }

//             res.add(curLevel);
//         }

//         return res;

//     }
// }
