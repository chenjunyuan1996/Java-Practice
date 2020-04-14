/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        } 
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode res = null;

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry == 1) {
            int s1 = stack1.isEmpty()? 0:stack1.pop();
            int s2 = stack2.isEmpty()? 0:stack2.pop();
            int val = s1 + s2 + carry;
            carry = val / 10;
            val %= 10;

            ListNode temp = new ListNode(val);
            temp.next = res;
            res = temp;
        }

        return res;
    }
}
