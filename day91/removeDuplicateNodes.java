/*
面试题 02.01. 移除重复节点
编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

示例1:
 输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]

示例2:
 输入：[1, 1, 1, 1, 2]
 输出：[1, 2]

链接: https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return head;

        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode pos = head;
        while (pos.next != null) {
            ListNode cur = pos.next;
            if (set.contains(cur.val)) {
                pos.next = cur.next;
            } else {
                set.add(cur.val);
                pos = pos.next;
            }
        }
        return head;

    }
}
