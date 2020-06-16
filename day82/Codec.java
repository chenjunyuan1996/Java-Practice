/*
297. 二叉树的序列化与反序列化
序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

链接: https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
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
public class Codec {

    int cur, end;
    String[] list;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return dfs(root, "");
    }

    private String dfs(TreeNode root, String str) {
        if (root == null) {
            str += "#,";
        } else {
            str += str.valueOf(root.val) + "," + dfs(root.left, str) + dfs(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        this.list = data.split(",");
        this.cur = 0;
        this.end = list.length;
        return deDfs();
    }

    private TreeNode deDfs() {
        if (this.cur == this.end) return null;

        if (this.list[this.cur].equals("#")) {
            this.cur++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(this.list[this.cur]));
        this.cur++;
        root.left = deDfs();
        root.right = deDfs();

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
