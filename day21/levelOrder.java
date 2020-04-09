// 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                tmp.add(curNode.val);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                } 
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
