/*
面试题06. 从尾到头打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

链接: https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
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
    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        int[] res = new int[size];

        cur = head;
        while (cur != null) {
            res[--size] = cur.val;
            cur = cur.next;
        }
        return res;

    }
}


// class Solution {
//     public List<Integer> tmp = new ArrayList<>();
//     public int[] reversePrint(ListNode head) {
//         recursion(head);
//         int[] res = new int[tmp.size()];
//         for (int i = 0; i < tmp.size(); i++) {
//             res[i] = tmp.get(i);
//         }
//         return res;
//     }
//     private void recursion(ListNode head) {
//         if (head == null) return;
//         recursion(head.next);
//         tmp.add(head.val);
//     }
// }
